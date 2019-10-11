package com.nanoo.model.enums;

/**
 * @author nanoo
 * @create 23/09/2019 - 15:20
 */
public enum EnumRating {
    
    THREE("3",1),THREE_PLUS("3+",2),
    FOUR_A("4a",3),FOUR_B("4b",4),FOUR_C("4c",5),
    FIVE_A("5a",6),FIVE_B("5b",7),FIVE_C("5c",8),
    SIX_A("6a",9),SIX_B("6b",10),SIX_C("6c",11),
    SEVEN_A("7a",12),SEVEN_B("7b",13),SEVEN_C("7c",14),
    HEIGHT_A("8a",15),HEIGHT_B("8b",16),HEIGHT_C("8c",17),
    NINE_A("9a",18),NINE_B("9b",19),NINE_C("9c",20);
    
    
    private final String abbreviation ;
    private final int level;
    
    EnumRating(String abbreviation, int level)
    {
        this.abbreviation = abbreviation ;
        this.level = level ;
    }
    
    public String getAbbreviation() {
        return abbreviation ;
    }
    
    public int getLevel() { return level; }
}
