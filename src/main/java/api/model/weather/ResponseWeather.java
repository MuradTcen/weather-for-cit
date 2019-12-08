package api.model.weather;

import lombok.Data;

public @Data
class ResponseWeather {

    private int temp;

    private int humidity;

    private int windSpeed;

    private String windDirection;

    public ResponseWeather(int temp, int humidity, int windSpeed, String windDirection) {
        this.temp = temp;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
    }
}
