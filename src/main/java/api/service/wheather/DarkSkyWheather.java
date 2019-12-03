package api.service.wheather;

import api.Application;
import api.model.wheather.ResponseWheather;
import api.model.wheather.darksky.DarkSkyValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class DarkSkyWheather implements Wheather {

    //    @Value(value = "${darkSkyWheatherApi.url}")
    private String url = "https://api.darksky.net/forecast";

    //    @Value(value = "${darkSkyWheatherApi.key}")
    private String key = "73eed20d99b93e2d18a4e224bfe937a4";

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Override
    public ResponseWheather getWeather(double latitude, double longitude) {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity entity = new HttpEntity(headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<DarkSkyValue> weather = restTemplate.exchange(
                url + "/" + key + "/" + latitude + "," + longitude,
                HttpMethod.GET, entity, DarkSkyValue.class);

        log.info(weather.toString());

        return new ResponseWheather(
                weather.getBody().getCurrently().getTemperature(),
                weather.getBody().getCurrently().getHumidity(),
                weather.getBody().getCurrently().getWindSpeed(),
                String.valueOf(weather.getBody().getCurrently().getWindGust()));
    }
}
