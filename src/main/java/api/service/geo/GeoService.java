package api.service.geo;

import api.Application;
import api.model.geo.GeoRequest;
import api.model.geo.GeoValue;
import api.model.geo.ResponseLocation;
import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeoService {

    //    @Value(value = "${daDataRu.url}")
    private String url = "https://suggestions.dadata.ru/suggestions/api/4_1/rs/suggest/address";

    //    @Value(value = "${daDataRu.key}")
    private String key = "a4d8ad96e5ad3a16cd1487eb3f25d6d80b860dfe";

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public ResponseLocation getCoordinates(String nameArea, int count) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Token " + key);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var geoRequest = new GeoRequest();

        geoRequest.setCount(count);
        geoRequest.setQuery(nameArea);

        HttpEntity<GeoRequest> entity = new HttpEntity<>(geoRequest, headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<GeoValue> geoLocation = restTemplate.exchange(url, HttpMethod.POST, entity, GeoValue.class);

        log.info(geoLocation.toString());

        if (geoLocation.getBody().getSuggestions().length > 0) {
            return new ResponseLocation(
                    geoLocation.getBody().getSuggestions()[0].getData().getGeo_lon(),
                    geoLocation.getBody().getSuggestions()[0].getData().getGeo_lat(),
                    geoLocation.getBody().getSuggestions()[0].getValue());
        }

        //todo нужна нормальная заглушка
        return new ResponseLocation(0., 0., "Не найдено");
    }
}
