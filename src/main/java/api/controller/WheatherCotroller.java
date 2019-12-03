package api.controller;

import api.model.wheather.ResponseWheather;
import api.service.wheather.WheatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WheatherCotroller {

    private WheatherService service;

    @Autowired
    public WheatherCotroller(WheatherService wheatherService) {
        this.service = wheatherService;
    }

    @GetMapping("/wheather-by-provider-lat-lon")
    public ResponseWheather getWeather(@RequestParam("provider") String provider,
                                       @RequestParam("lat") double latitude,
                                       @RequestParam("lon") double longitude) {
        return service.getWeatherByLatAndLon(provider, latitude, longitude);
    }
}
