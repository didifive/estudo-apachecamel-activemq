package br.com.camel.notifier.routes;

import br.com.camel.notifier.components.HighTempAlertProcessor;
import br.com.camel.notifier.components.TempNotificationProcessor;
import br.com.camel.notifier.models.TempSensor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.ListJacksonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class NotifierRoute extends RouteBuilder {

    @Autowired
    TempNotificationProcessor tempNotificationProcessor;

    @Override
    public void configure() throws Exception {
        from("activemq:temp-notify?jmsMessageType=Text")
                .routeId("route.temp.notify")
                .unmarshal(new ListJacksonDataFormat(TempSensor.class))
                .process(new TempNotificationProcessor())
                .log("Notificação de temperaturas enviada em: " + OffsetDateTime.now());

        from("activemq:high-temp-notify?jmsMessageType=Text")
                .routeId("route.high.temp.notify")
                .unmarshal(new ListJacksonDataFormat(TempSensor.class))
                .process(new HighTempAlertProcessor())
                .log("ALERTA de temperaturas altas enviada em: " + OffsetDateTime.now());
    }
}
