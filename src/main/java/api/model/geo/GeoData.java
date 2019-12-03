package api.model.geo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
public @Data
class GeoData {

    private float geo_lat;

    private float geo_lon;
}
