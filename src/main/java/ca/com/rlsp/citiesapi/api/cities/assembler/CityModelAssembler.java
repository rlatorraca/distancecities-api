package ca.com.rlsp.citiesapi.api.cities.assembler;

import ca.com.rlsp.citiesapi.api.cities.dto.output.CityOutput;
import ca.com.rlsp.citiesapi.api.cities.model.City;
import ca.com.rlsp.citiesapi.api.countries.dto.output.CountryOutput;
import ca.com.rlsp.citiesapi.api.countries.model.Country;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CityModelAssembler {

    private ModelMapper modelMapper;

    public CityModelAssembler(ModelMapper modelMapper) {

        this.modelMapper = modelMapper;
    }

    /*
               Convert MODEL -> DTO / Ouput
           */
    public CityOutput fromControllerToInput(City city) {
        CityOutput cityOutput = new CityOutput();

        System.out.println(city.getLocation());
        cityOutput.setId(city.getId());
        cityOutput.setName(city.getName());
        cityOutput.setIbge(city.getIbge());
        cityOutput.setLocation(city.getLocation());
        cityOutput.setGeolocation(city.getGeolocation());
        cityOutput.setProvincecode(city.getProvincecode());

        return cityOutput;
    }


    /*
        Convert MODEL -> DTO (list GET)
    */
    public List<CityOutput> fromControllerToOutputList(List<City> cities){
        return cities.stream()
                .map(city -> fromControllerToOutput(city))
                .collect(Collectors.toList());
    }


    /*
        Convert MODEL -> DTO para PUT
    */
    public CityOutput fromControllerToOutput(City city) {

        return modelMapper.map(city, CityOutput.class); // Mas o mapeamento substituindo o codigo acima
    }
}
