package com.nanoo.consumer.entities.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:15
 */
public class City implements Serializable {

    private Long id;
    private int postalCode;
    private String city;
    
    public City() {
        super();
    }
    
    public City(Long id, int postalCode, String city) {
        this.id = id;
        this.postalCode = postalCode;
        this.city = city;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public int getPostalCode() {
        return postalCode;
    }
    
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
}
