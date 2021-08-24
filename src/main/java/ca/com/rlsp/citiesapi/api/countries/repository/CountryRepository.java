package ca.com.rlsp.citiesapi.api.countries.repository;

import ca.com.rlsp.citiesapi.api.countries.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
