package api.service.wheather;

import api.model.wheather.ResponseWheather;
import org.springframework.web.client.RestTemplate;

public interface Wheather {
    public ResponseWheather getWeather(double latitude, double longitude);
}
