package com.nanoo.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:12
 */
@Embeddable
@Data @NoArgsConstructor
public class Address {
    
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "postal_code")
    private int postalCode;
    private String city;
    
}
