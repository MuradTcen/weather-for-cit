package api.service.wheather;

import api.model.wheather.*;
import org.springframework.stereotype.Service;

@Service
public class WheatherService {

    private Wheather wheather;

    public ResponseWheather getWeatherByLatAndLon(String wheatherProvider, double latitude, double longitude) {
        switch (wheatherProvider) {
            case ("dark-sky"):
                wheather = new DarkSkyWheather();
                break;
            case ("open"):
                wheather = new OpenWheather();
                break;
            // здесь дублируется код, чтобы можно было в явном виде выбрать яндекс
            case ("yandex"):
                wheather = new YandexWheather();
                break;
            default:
                wheather = new YandexWheather();
                break;
        }

        return wheather.getWeather(latitude, longitude);
    }
}
