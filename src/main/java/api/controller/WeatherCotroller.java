package api.controller;

import api.model.weather.ResponseWeather;
import api.service.weather.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherCotroller {

    private WeatherService service;

    @Autowired
    public WeatherCotroller(WeatherService weatherService) {
        this.service = weatherService;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/wheather-by-provider-lat-lon")
    public ResponseWeather getWeather(@RequestParam(value = "provider", required=false) String provider,
                                      @RequestParam("lat") double latitude,
                                      @RequestParam("lon") double longitude) {
        return service.getWeatherByLatAndLon(provider, latitude, longitude);
    }
}
