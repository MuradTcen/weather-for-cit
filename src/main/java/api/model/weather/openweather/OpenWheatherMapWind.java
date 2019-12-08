package api.model.weather.openweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
public @Data
class OpenWheatherMapWind {

    private int speed;

    private int deg;
}
