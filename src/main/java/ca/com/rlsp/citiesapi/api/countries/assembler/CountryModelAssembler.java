package ca.com.rlsp.citiesapi.api.countries.assembler;

import ca.com.rlsp.citiesapi.api.countries.dto.output.CountryOutput;
import ca.com.rlsp.citiesapi.api.countries.model.Country;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CountryModelAssembler {

    private ModelMapper modelMapper;

    public CountryModelAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /*
               Convert MODEL -> DTO / Ouput
           */
    public CountryOutput fromControllerToInput(Country country) {
        CountryOutput countryOutput = new CountryOutput();


        countryOutput.setId(country.getId());
        countryOutput.setName(country.getName());
        countryOutput.setNiceName(country.getNiceName());
        countryOutput.setIso3(country.getIso3());
        countryOutput.setNumCode(country.getNumCode());
        countryOutput.setPhoneCode(country.getPhoneCode());

        return countryOutput;
    }


    /*
        Convert MODEL -> DTO (list GET)
    */
    public List<CountryOutput> fromControllerToOutputList(List<Country> countries){
        return countries.stream()
                .map(country -> fromControllerToOutput(country))
                .collect(Collectors.toList());
    }


    /*
        Convert MODEL -> DTO para PUT
    */
    public CountryOutput fromControllerToOutput(Country country) {

        return modelMapper.map(country, CountryOutput.class); // Mas o mapeamento substituindo o codigo acima
    }
}
