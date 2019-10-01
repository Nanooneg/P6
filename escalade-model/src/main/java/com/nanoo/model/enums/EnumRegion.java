package com.nanoo.model.enums;

/**
 * @author nanoo
 * @create 23/09/2019 - 18:11
 */
public enum EnumRegion {
    
    AUVERGNE_RHONE_ALPES("Auvergne-Rhône-Alpes"),
    BOURGOGNE_FRANCHE_COMPTE("Bourgogne-Franche-Comté"),
    BRETAGNE("Bretagne"),
    CENTRE_VAL_DE_LOIRE("Centre-Val-de-Loire"),
    CORSE("Corse"),
    GRAND_EST("Grand-Est"),
    GUYANNE("Guyane"),
    HAUTS_DE_FRANCE("Hauts-de-France"),
    ILE_DE_FRANCE("Ile-de-France"),
    NORMANDIE("Normandie"),
    NOUVELLE_AQUITAINE("Nouvelle-Aquitaine"),
    OCCITANIE("Occitanie"),
    PAYS_DE_LA_LOIRE("Paye-de-la-Loire"),
    PACA("Paca"),
    REUNION("Réunion");
    
    private String abbreviation ;
    
    EnumRegion(String abbreviation) {
        this.abbreviation = abbreviation ;
    }
    
    public String getAbbreviation() {
        return  this.abbreviation ;
    }
}
