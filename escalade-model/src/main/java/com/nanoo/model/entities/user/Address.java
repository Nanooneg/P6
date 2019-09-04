package com.nanoo.model.entities.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:12
 */
@Entity
@Data
@NoArgsConstructor
public class Address implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "street_nbr")
    private String streetNbr;
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "id_city_code")
    private Integer idCityCode;
    
}
