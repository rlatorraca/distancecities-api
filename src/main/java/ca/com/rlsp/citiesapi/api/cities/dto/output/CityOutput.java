package ca.com.rlsp.citiesapi.api.cities.dto.output;

import ca.com.rlsp.citiesapi.api.cities.model.PointType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

import javax.persistence.Column;

@Setter
@Getter
@TypeDefs(value = {
        @TypeDef(name = "point", typeClass = PointType.class)
})
public class CityOutput {

    public Long id;
    public String name;
    public Integer provincecode;
    public Integer ibge;
    public String geolocation;
    @Type(type = "point")
    @Column(name = "lat_lon", updatable = false, insertable = false)
    public Point location;
}
