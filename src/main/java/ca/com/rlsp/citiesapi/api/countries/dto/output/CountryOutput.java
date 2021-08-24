package ca.com.rlsp.citiesapi.api.countries.dto.output;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CountryOutput {

    public Long id;

    public String iso;

    public String name;

    public String niceName;

    public String iso3;

    public Integer numCode;

    public Integer phoneCode;
}
