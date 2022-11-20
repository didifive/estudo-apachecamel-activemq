package br.com.camel.tempsensor.components;

import br.com.camel.tempsensor.models.TempSensor;
import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;

@Component
public class CurrentTempComponent {
    public TempSensor currentTemp() {
        NumberFormat nf= NumberFormat.getNumberInstance(Locale.ENGLISH);
        nf.setMaximumFractionDigits(2);
        var temp = new Random().nextDouble(0,1000);

        return TempSensor.builder().temp(nf.format(temp)).build();
    }
}
