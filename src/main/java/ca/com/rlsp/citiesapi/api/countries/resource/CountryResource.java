package ca.com.rlsp.citiesapi.api.countries.resource;

import ca.com.rlsp.citiesapi.api.countries.repository.CountryRepository;
import ca.com.rlsp.citiesapi.api.countries.assembler.CountryModelAssembler;
import ca.com.rlsp.citiesapi.api.countries.dto.output.CountryOutput;
import ca.com.rlsp.citiesapi.api.countries.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("countries")
public class CountryResource {


    //@Autowired
    private CountryRepository countryRepository;

    //@Autowired
    private CountryModelAssembler countryModelAssembler;

    public CountryResource(CountryRepository countryRepository, CountryModelAssembler countryModelAssembler) {
        this.countryRepository = countryRepository;
        this.countryModelAssembler = countryModelAssembler;
    }

    @GetMapping
    public List<CountryOutput> allCountries(){
        List<Country> allCountries = countryRepository.findAll();

        return countryModelAssembler.fromControllerToOutputList(allCountries);
    }

    @GetMapping("/pageable")
    public Page<CountryOutput> allCountriesByPage(@PageableDefault(size = 10) Pageable pageable){
        Page<Country> allCountries = countryRepository.findAll(pageable);

        List<CountryOutput> countryOutput = countryModelAssembler.fromControllerToOutputList(allCountries.getContent());

        Page<CountryOutput> countryOutputPage = new PageImpl<>(countryOutput, pageable,
                allCountries.getTotalElements());
        return countryOutputPage;
    }

    @GetMapping("/{countryId}")
    public ResponseEntity<CountryOutput> getOneCountry(@PathVariable(name = "countryId") Long id){
        Optional<Country> country = countryRepository.findById(id);

        if(country.isPresent()){
            CountryOutput countryOutput = countryModelAssembler.fromControllerToInput(country.get());
            return ResponseEntity.status(HttpStatus.OK).body(countryOutput);
        } else {
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Country Not Found");
        }

    }


}
