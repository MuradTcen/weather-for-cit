package api.service.weather;

import api.model.weather.ResponseWeather;

public interface Weather {
    public ResponseWeather getWeather(double latitude, double longitude);
}
