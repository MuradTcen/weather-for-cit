package api.model.wheather;

import lombok.Data;

public @Data
class ResponseWheather {

    private int temp;

    private int humidity;

    private int windSpeed;

    private String windDirection;

    public ResponseWheather(int temp, int humidity, int windSpeed, String windDirection) {
        this.temp = temp;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
    }
}
