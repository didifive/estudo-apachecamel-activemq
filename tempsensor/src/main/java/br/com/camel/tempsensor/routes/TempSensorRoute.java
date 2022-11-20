package br.com.camel.tempsensor.routes;

import br.com.camel.tempsensor.components.CurrentTempComponent;
import br.com.camel.tempsensor.components.LogComponent;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TempSensorRoute extends RouteBuilder {

    @Autowired
    private CurrentTempComponent currentTempComponent;

    @Override
    public void configure() throws Exception {
        from("timer:generate-data?period=1000")
                .bean("currentTempComponent","currentTemp")
                .process(new LogComponent())
                .marshal().json(JsonLibrary.Jackson)
                .to("activemq:temp-sensor?jmsMessageType=Text");
    }
}
