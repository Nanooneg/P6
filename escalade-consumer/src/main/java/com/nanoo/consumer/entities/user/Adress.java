package com.nanoo.consumer.entities.user;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:12
 */
public class Adress implements Serializable {
    
    private Long id;
    private String streetNbr;
    private String streetName;
    private City city;
    
    public Adress() {
        super();
    }
    
    public Adress(Long id, String streetNbr, String streetName, City city) {
        this.id = id;
        this.streetNbr = streetNbr;
        this.streetName = streetName;
        this.city = city;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getStreetNbr() {
        return streetNbr;
    }
    
    public void setStreetNbr(String streetNbr) {
        this.streetNbr = streetNbr;
    }
    
    public String getStreetName() {
        return streetName;
    }
    
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    
    public City getCity() {
        return city;
    }
    
    public void setCity(City city) {
        this.city = city;
    }
}
