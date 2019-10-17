package com.nanoo.model.enums;

/**
 * @author nanoo
 * @create 16/10/2019 - 18:16
 */
public enum EnumStatus {
    
    PENDING("En attente"), ACCEPTED("Accepté"), REFUSED("Réfusé");
    
    private String abbreviation ;
    
    private EnumStatus(String abbreviation) {
        this.abbreviation = abbreviation ;
    }
    
    public String getAbbreviation() {
        return  this.abbreviation ;
    }
    
}
