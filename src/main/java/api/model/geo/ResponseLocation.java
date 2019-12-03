package api.model.geo;

import lombok.Data;

public @Data
class ResponseLocation {

    private double longitude;

    private double latitude;

    private String name;

    public ResponseLocation(double longitude, double latitude, String name) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
    }
}
