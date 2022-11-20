package br.com.camel.notifier.models;

public record TempSensor(String deviceName
        , String temp
        , String timestamp) {

    public static TempSensorBuilder builder() {
        return new TempSensorBuilder();
    }

    public static class TempSensorBuilder {

        private String deviceName;
        private String temp;
        private String timestamp;

        public TempSensorBuilder deviceName(final String deviceName) {
            this.deviceName = deviceName;
            return this;
        }

        public TempSensorBuilder temp(final String temp) {
            this.temp = temp;
            return this;
        }

        public TempSensorBuilder timestamp(final String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public TempSensor build() {
            return new TempSensor(deviceName, temp, timestamp);
        }
    }
}
