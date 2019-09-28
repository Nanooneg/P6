package com.nanoo.model.enums;

/**
 * @author nanoo
 * @create 23/09/2019 - 15:20
 */
public enum EnumRating {
    
    THREE("3"),THREE_PLUS("3+"),
    FOUR_A("4a"),FOUR_B("4b"),FOUR_C("4c"),
    FIVE_A("5a"),FIVE_B("5b"),FIVE_C("5c"),
    SIX_A("6a"),SIX_B("6b"),SIX_C("6c"),
    SEVEN_A("7a"),SEVEN_B("7b"),SEVEN_C("7c"),
    HEIGHT_A("8a"),HEIGHT_B("8b"),HEIGHT_C("8c"),
    NINE_A("9a"),NINE_B("9b"),NINE_C("9c");
    
    
    private final String abbreviation ;
    
    EnumRating(String abbreviation) {
        this.abbreviation = abbreviation ;
    }
    
    public String getAbbreviation() {
        return abbreviation ;
    }

}
