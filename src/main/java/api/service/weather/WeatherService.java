package api.service.weather;

import api.model.weather.*;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private Weather weather;

    public ResponseWeather getWeatherByLatAndLon(String wheatherProvider, double latitude, double longitude) {
        switch (wheatherProvider) {
            case (WeatherUnlocked.NAME):
                weather = new WeatherUnlocked();
                break;
            case (DarkSkyWeather.NAME):
                weather = new DarkSkyWeather();
                break;
            case (OpenWeather.NAME):
                weather = new OpenWeather();
                break;
            // здесь дублируется код, чтобы можно было в явном виде выбрать яндекс
            case (YandexWeather.NAME):
                weather = new YandexWeather();
                break;
            default:
                weather = new YandexWeather();
                break;
        }

        return weather.getWeather(latitude, longitude);
    }
}
