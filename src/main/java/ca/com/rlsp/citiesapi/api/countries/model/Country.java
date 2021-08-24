package ca.com.rlsp.citiesapi.api.countries.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotNull
    public String iso;

    @NotNull
    public String name;

    @NotNull
    @Column(name = "nicename")
    public String niceName;

    @NotNull
    public String iso3;

    @NotNull
    @Column(name = "numcode")
    public Integer numCode;

    @NotNull
    @Column(name = "phonecode")
    public Integer phoneCode;
}
