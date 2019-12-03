package api.model.wheather.openwheather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
public @Data
class OpenWheatherMapMain {

    private int temp;

    private int humidity;
}
