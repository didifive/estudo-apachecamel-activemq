package br.com.camel.notifier.components;

import br.com.camel.notifier.models.TempSensor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TempNotificationProcessor implements Processor {

    @Autowired
    private EMailService eMailService;

    @Override
    public void process(Exchange exchange) throws Exception {
        var tempList = (List<TempSensor>) exchange.getMessage().getBody();
        var averageTemp = tempList.stream()
                .map(TempSensor::temp)
                .mapToDouble(Double::parseDouble)
                .average()
                .orElseThrow();
        var maxTemp = tempList.stream()
                .map(TempSensor::temp)
                .mapToDouble(Double::parseDouble)
                .max()
                .orElseThrow();
        var minTemp = tempList.stream()
                .map(TempSensor::temp)
                .mapToDouble(Double::parseDouble)
                .min()
                .orElseThrow();
        var minTimestamp = tempList.stream()
                .map(TempSensor::timestamp)
                .map(OffsetDateTime::parse)
                .min(OffsetDateTime::compareTo)
                .orElseThrow();
        var maxTimestamp = tempList.stream()
                .map(TempSensor::timestamp)
                .map(OffsetDateTime::parse)
                .max(OffsetDateTime::compareTo)
                .orElseThrow();

        var message = String.format("""
                        No período de %s até %s %n
                        A média da temperatura foi de %.2f %n
                        A temperatura mais alta foi %.2f %n
                        A temperatura mais baixa foi %.2f %n%n"""
                , minTimestamp.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
                , maxTimestamp.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
                , averageTemp, maxTemp, minTemp);
        message += tempList.stream()
                .map(temp ->
                        String.format("Dispositivo: %s - Temperatura: %sºC - Timestamp: %s %n"
                                , temp.deviceName(), temp.temp(), temp.timestamp()))
                .collect(Collectors.joining());

        eMailService.send("Notificação de temperatura", message);

    }
}
