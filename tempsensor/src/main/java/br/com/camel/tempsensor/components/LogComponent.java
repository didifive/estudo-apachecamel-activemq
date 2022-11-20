package br.com.camel.tempsensor.components;

import br.com.camel.tempsensor.models.TempSensor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LogComponent implements Processor {
    private final Logger logger = LoggerFactory.getLogger("IoT Device - TempSensor");

    @Override
    public void process(Exchange exchange) throws Exception {
        logger.info("Em {} o dispositivo {} estava com a temperatura de {} graus celcius"
                , exchange.getMessage().getBody(TempSensor.class).timestamp().isBlank()
                        ? ""
                        : exchange.getMessage().getBody(TempSensor.class).timestamp()
                , exchange.getMessage().getBody(TempSensor.class).deviceName().isBlank()
                        ? ""
                        : exchange.getMessage().getBody(TempSensor.class).deviceName()
                , exchange.getMessage().getBody(TempSensor.class).temp().isBlank()
                        ? ""
                        : exchange.getMessage().getBody(TempSensor.class).temp());
    }
}
