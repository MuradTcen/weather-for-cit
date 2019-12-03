package api.model.wheather.openwheather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
public @Data
class OpenWheatherMapValue {

    private String dt;

    private OpenWheatherMapMain main;

    private OpenWheatherMapWind wind;
}
