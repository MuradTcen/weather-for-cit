package api.model.weather.yandexweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
public @Data
class WheatherYandexValue {
    private String now_dt;

    private WheatherYandexFact fact;
}
