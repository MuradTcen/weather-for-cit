package api.model.geo;

import lombok.Data;

public @Data
class GeoRequest {

    private String query;

    private int count;
}
