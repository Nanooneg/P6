package com.nanoo.model.enums;

/**
 * @author nanoo
 * @create 05/09/2019 - 14:23
 */
public enum EnumTitle {
    
    MR("Mr"),MME("Mme"),MLLE("Mlle");
    
    private String abbreviation ;
    
    EnumTitle(String abbreviation) {
        this.abbreviation = abbreviation ;
    }
    
    public String getAbbreviation() {
        return  this.abbreviation ;
    }
    
}
