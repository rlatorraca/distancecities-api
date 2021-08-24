package ca.com.rlsp.citiesapi.api.cities.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_city_br")
@TypeDefs(value = {
        @TypeDef(name = "point", typeClass = PointType.class)
})
@Data
@AllArgsConstructor
public class City {

    @Id
    private Long id;

    private String name;

    private Integer provincecode;

    private Integer ibge;

    // 1st
    @Column(name = "lat_lon")
    private String geolocation;

    // 2nd
    @Type(type = "point")
    @Column(name = "lat_lon", updatable = false, insertable = false)
    private Point location;

    public City() {

    }
}
