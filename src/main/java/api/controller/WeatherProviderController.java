package api.controller;

import api.model.geo.ResponseLocation;
import api.model.weather.ResponseProvider;
import api.service.geo.GeoService;
import api.service.weather.DarkSkyWeather;
import api.service.weather.OpenWeather;
import api.service.weather.WeatherUnlocked;
import api.service.weather.YandexWeather;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherProviderController {

    //todo поискать лучшее решение
    private String[] providers = {
            YandexWeather.NAME,
            WeatherUnlocked.NAME
    };

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/weather-provider")
    public ResponseProvider getWeather() {

        return new ResponseProvider(providers);
    }
}
