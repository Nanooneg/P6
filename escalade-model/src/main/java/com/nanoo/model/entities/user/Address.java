package com.nanoo.model.entities.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:12
 */
@Embeddable
@Data @NoArgsConstructor
public class Address implements Serializable {
    
    @Column(name = "street_nbr")
    private String streetNbr;
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "postal_code")
    private int postalCode;
    private String city;
    
}
