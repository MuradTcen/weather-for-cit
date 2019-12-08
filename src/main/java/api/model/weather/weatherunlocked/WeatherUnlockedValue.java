package api.model.weather.weatherunlocked;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
public @Data
class WeatherUnlockedValue {

    private int temp_c;

    private int humid_pct;

    private int windspd_ms;

    private String winddir_compass;
}
