package api.service.weather;

import api.Application;
import api.model.weather.ResponseWeather;
import api.model.weather.openweather.OpenWheatherMapValue;
import api.model.weather.weatherunlocked.WeatherUnlockedValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class WeatherUnlocked implements Weather {

    @Value("${weatherunlockedApi.url}")
    private String url = "http://api.weatherunlocked.com/api/current";

    @Value("${weatherunlockedApi.key}")
    private String key = "92a487a621cfc9c495beb275992f546a";

    @Value("${weatherunlockedApi.appID}")
    private String appID = "251e71ce";

    public static final String NAME = "unlocked";

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Override
    public ResponseWeather getWeather(double latitude, double longitude) {
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setContentLength(443);
        HttpEntity entity = new HttpEntity(headers);

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(
                url + "/" + latitude + ","  + longitude
        )
                .queryParam("app_id", appID)
                .queryParam("app_key", key);

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        System.out.println(uriBuilder.toUriString());
        ResponseEntity<WeatherUnlockedValue> weather = restTemplate.exchange(
                uriBuilder.toUriString(), HttpMethod.GET, entity, WeatherUnlockedValue.class);

        log.info(weather.toString());

        return new ResponseWeather(
                weather.getBody().getTemp_c(),
                weather.getBody().getHumid_pct(),
                weather.getBody().getWindspd_ms(),
                weather.getBody().getWinddir_compass()
        );
    }
}
