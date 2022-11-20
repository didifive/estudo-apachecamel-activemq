package br.com.camel.tempmonitor.components;

import br.com.camel.tempmonitor.models.TempSensor;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;


import static br.com.camel.tempmonitor.routes.TempMonitorRoute.HIGH_TEMP;

@Component
public class TempCheckComponent {

    private TempCheckComponent() {
    }

    public static boolean isHighTemp(Exchange exchange) throws Exception {
        var tempString = exchange.getMessage().getBody(TempSensor.class).temp();
        var temp = Double.parseDouble(tempString);
        return temp > HIGH_TEMP;
    }
}
