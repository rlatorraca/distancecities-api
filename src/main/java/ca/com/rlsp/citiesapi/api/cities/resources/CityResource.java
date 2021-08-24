package ca.com.rlsp.citiesapi.api.cities.resources;


import ca.com.rlsp.citiesapi.api.cities.assembler.CityModelAssembler;
import ca.com.rlsp.citiesapi.api.cities.dto.output.CityOutput;
import ca.com.rlsp.citiesapi.api.cities.model.City;
import ca.com.rlsp.citiesapi.api.cities.repository.CityRepository;
import ca.com.rlsp.citiesapi.api.countries.assembler.CountryModelAssembler;
import ca.com.rlsp.citiesapi.api.countries.dto.output.CountryOutput;
import ca.com.rlsp.citiesapi.api.countries.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cities")
public class CityResource {

    private final CityRepository repository;


    private final CityModelAssembler cityModelAssembler;

    public CityResource(CityRepository repository, CityModelAssembler cityModelAssembler) {
        this.repository = repository;
        this.cityModelAssembler = cityModelAssembler;
    }

    /* 1st
  @GetMapping
  public List<City> cities() {
      return repository.findAll();
  }*/

    // 2nd - Pageable

    @GetMapping("/pageable")
    public Page<CityOutput> allCitiesByPage(@PageableDefault(size = 10) Pageable pageable){
        Page<City> allCities = repository.findAll(pageable);

        List<CityOutput> countryOutput = cityModelAssembler.fromControllerToOutputList(allCities.getContent());

        Page<CityOutput> countryOutputPage = new PageImpl<>(countryOutput, pageable,
                allCities.getTotalElements());
        return countryOutputPage;
    }
}
