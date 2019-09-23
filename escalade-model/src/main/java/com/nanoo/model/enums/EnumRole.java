package com.nanoo.model.enums;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:16
 */
public enum EnumRole {
    
    ADMIN("Administrator"), MEMBER("Association member"), USER("Consumer");
    
    private String abbreviation ;
    
    private EnumRole(String abbreviation) {
        this.abbreviation = abbreviation ;
    }
    
    public String getAbbreviation() {
        return  this.abbreviation ;
    }
    
}
