package br.com.camel.tempmonitor.routes;

import br.com.camel.tempmonitor.components.TempCheckComponent;
import br.com.camel.tempmonitor.models.TempSensor;
import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.AggregationStrategies;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class TempMonitorRoute extends RouteBuilder {

    public static final Long TEMP_NOTIFY_TIMEOUT = 60000L;
    public static final Integer HIGH_TEMP = 700;
    public static final Integer HIGH_TEMP_AMOUNT_CRITICAL_STATUS = 5;


    @Override
    public void configure() throws Exception {
        from("activemq:temp-sensor?jmsMessageType=Text")
                .routeId("route.tempsensor.queue")
                .unmarshal().json(TempSensor.class)
                .to(ExchangePattern.InOnly, "seda:temp-check");

        from("seda:temp-check")
                .routeId("route.temperature.check")
                .to(ExchangePattern.InOnly, "seda:temperature-notify")
                .choice()
                    .when(method(TempCheckComponent.class, "isHighTemp"))
                        .to(ExchangePattern.InOnly, "seda:high-temperature-notify")
                .endChoice()
                .end();

        from("seda:high-temperature-notify")
                .routeId("route.high.temperature.notify")
                .aggregate(constant(true))
                    .aggregationStrategy(AggregationStrategies.groupedBody())
                    .completionSize(HIGH_TEMP_AMOUNT_CRITICAL_STATUS)
                .marshal().json(JsonLibrary.Jackson)
                .log("notify aggregated high temperatures alert")
                .to("activemq:high-temp-notify?jmsMessageType=Text");

        from("seda:temperature-notify")
                .routeId("route.temperature.notify")
                .aggregate(constant(true))
                    .aggregationStrategy(AggregationStrategies.groupedBody())
                    .completionTimeout(TEMP_NOTIFY_TIMEOUT)
                    .completionSize((int) (TEMP_NOTIFY_TIMEOUT / 1000))
                .marshal().json(JsonLibrary.Jackson)
                .log("notify aggregated temperatures")
                .to("activemq:temp-notify?jmsMessageType=Text");
    }
}
