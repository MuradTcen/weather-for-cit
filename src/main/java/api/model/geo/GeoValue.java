package api.model.geo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@JsonIgnoreProperties(ignoreUnknown = true)
public @Data
class GeoValue {

    private Suggestion[] suggestions;
}
