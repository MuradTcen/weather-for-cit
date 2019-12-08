package api.model.weather.yandexweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
public @Data
class WheatherYandexFact {

    private int temp;

    private int humidity;

    private int wind_speed;

    private String wind_dir;
}
