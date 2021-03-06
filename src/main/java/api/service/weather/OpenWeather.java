package api.service.weather;

import api.Application;
import api.model.weather.ResponseWeather;
import api.model.weather.openweather.OpenWheatherMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class OpenWeather implements Weather {

    @Value("${openWheatherApi.url}")
    private String url = "http://api.openweathermap.org/data/2.5/weather";

    @Value("${openWheatherApi.key}")
    private String key = "47a415e08454fc627663446421b524a9";

    private String units = "metric";

    public static final String NAME = "open";

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Override
    public ResponseWeather getWeather(double latitude, double longitude) {
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setContentLength(443);
        HttpEntity entity = new HttpEntity(headers);

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("lat", latitude)
                .queryParam("lon", longitude)
                .queryParam("units", units)
                .queryParam("APPID", key);

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        ResponseEntity<OpenWheatherMapValue> weather = restTemplate.exchange(
                uriBuilder.toUriString(), HttpMethod.GET, entity, OpenWheatherMapValue.class);

        log.info(weather.toString());

        return new ResponseWeather(
                weather.getBody().getMain().getTemp(),
                weather.getBody().getMain().getHumidity(),
                weather.getBody().getWind().getSpeed(),
                String.valueOf(weather.getBody().getWind().getDeg()));
    }
}
