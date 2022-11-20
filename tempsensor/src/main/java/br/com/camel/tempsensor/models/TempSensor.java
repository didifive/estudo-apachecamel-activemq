package br.com.camel.tempsensor.models;

import java.time.OffsetDateTime;

public record TempSensor(String deviceName
        , String temp
        , String timestamp) {

    public static TempSensorBuilder builder() {
        return new TempSensorBuilder();
    }

    public static class TempSensorBuilder {

        private String temp;

        public TempSensorBuilder temp(final String temp) {
            this.temp = temp;
            return this;
        }

        public TempSensor build() {
            return new TempSensor("TempSensor Device", temp, OffsetDateTime.now().toString());
        }
    }
}
