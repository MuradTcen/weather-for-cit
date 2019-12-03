package api.service.wheather;

import api.Application;
import api.model.wheather.ResponseWheather;
import api.model.wheather.yandexwheather.WheatherYandexValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class YandexWheather implements Wheather {

    //    @Value(value = "${yandexWheatherApi.url}")
    private String url = "https://api.weather.yandex.ru/v1/forecast";

    //    @Value(value = "${yandexWheatherApi.key}")
    private String key = "730256bf-599e-48f5-b81a-eb75dcae4152";

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Override
    public ResponseWheather getWeather(double latitude, double longitude) {
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-Yandex-API-Key", key);

        HttpEntity entity = new HttpEntity(headers);

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("lat", latitude)
                .queryParam("lon", longitude);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<WheatherYandexValue> weather = restTemplate.exchange(
                uriBuilder.toUriString(), HttpMethod.GET, entity, WheatherYandexValue.class);

        log.info(weather.toString());

        return new ResponseWheather(
                weather.getBody().getFact().getTemp(),
                weather.getBody().getFact().getHumidity(),
                weather.getBody().getFact().getWind_speed(),
                weather.getBody().getFact().getWind_dir());
    }
}
