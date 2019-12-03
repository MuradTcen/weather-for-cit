package api.model.wheather.darksky;

import lombok.Data;

public @Data
class DarkSkyCurrently {

    private String time;

    private int temperature;

    private int humidity;

    private int windSpeed;

    private int windGust;
}
