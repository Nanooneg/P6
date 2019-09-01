package com.nanoo.consumer.entities.topo;

import org.joda.time.DateTime;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:17
 */
public class Topo {

    private Long id;
    private Long idAccount;
    private String name;
    private String description;
    private String country;
    private String region;
    private DateTime dateOfPublication;
    private boolean isLendable;
    
    public Topo() {
    }
    
    public Topo(Long id, Long idAccount, String name, String description, String country, String region, DateTime dateOfPublication, boolean isLendable) {
        this.id = id;
        this.idAccount = idAccount;
        this.name = name;
        this.description = description;
        this.country = country;
        this.region = region;
        this.dateOfPublication = dateOfPublication;
        this.isLendable = isLendable;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getIdAccount() {
        return idAccount;
    }
    
    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getRegion() {
        return region;
    }
    
    public void setRegion(String region) {
        this.region = region;
    }
    
    public DateTime getDateOfPublication() {
        return dateOfPublication;
    }
    
    public void setDateOfPublication(DateTime dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }
    
    public boolean isLendable() {
        return isLendable;
    }
    
    public void setLendable(boolean lendable) {
        isLendable = lendable;
    }
}
