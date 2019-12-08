package api.controller;

import api.model.geo.ResponseLocation;
import api.service.geo.GeoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeoController {

    private GeoService service;

    private int countSuggestions = 1;

    public GeoController(GeoService service) {
        this.service = service;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/coordinates-by-name")
    public ResponseLocation getCoordinates(@RequestParam("name") String name) {
        return service.getCoordinates(name, countSuggestions);
    }
}
