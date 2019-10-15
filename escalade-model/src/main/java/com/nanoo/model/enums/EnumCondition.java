package com.nanoo.model.enums;

/**
 * @author nanoo
 * @create 14/10/2019 - 10:37
 */
public enum EnumCondition {

    NEW("Neuf"),GOOD("Bon état"),WORN("Usé");
    
    private String abbreviation ;
    
    private EnumCondition(String abbreviation) {
        this.abbreviation = abbreviation ;
    }
    
    public String getAbbreviation() {
        return  this.abbreviation ;
    }

}
