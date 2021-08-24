package ca.com.rlsp.citiesapi.api.cities.resources;

import ca.com.rlsp.citiesapi.api.cities.service.DistanceService;
import ca.com.rlsp.citiesapi.api.cities.service.EarthRadius;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/distances")
public class DistanceResource {

    private DistanceService service;
    Logger log = LoggerFactory.getLogger(DistanceResource.class);

    public DistanceResource(DistanceService service) {
        this.service = service;
    }

    @GetMapping("/by-points")
    public ResponseEntity<Double> byPoints(@RequestParam(name = "from") final Long city1,
                                   @RequestParam(name = "to") final Long city2,
                                   @RequestParam(name = "unit") final EarthRadius unit) {
        log.info("byPoints");
        //return service.distanceByPointsInMiles(city1, city2);
        return ResponseEntity.status(HttpStatus.OK).body(service.distanceUsingMath(city1, city2, unit));
    }

    @GetMapping("/by-cube")
    public ResponseEntity<Double>  byCube(@RequestParam(name = "from") final Long city1,
                         @RequestParam(name = "to") final Long city2,
                         @RequestParam(name = "unit") final EarthRadius unit) {
        log.info("byCube");
        //return service.distanceByCubeInMeters(city1, city2);
        return ResponseEntity.status(HttpStatus.OK).body(service.distanceUsingPoints(city1, city2, unit));
    }

    @GetMapping("/by-math")
    public Double byMath(@RequestParam(name = "from") final Long city1,
                         @RequestParam(name = "to") final Long city2,
                         @RequestParam final EarthRadius unit) {
        log.info("byMath");
        return service.distanceUsingMath(city1, city2, unit);
    }
}
