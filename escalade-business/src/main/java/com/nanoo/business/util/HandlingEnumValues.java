package com.nanoo.business.util;

import com.nanoo.model.enums.EnumCondition;
import com.nanoo.model.enums.EnumRating;
import com.nanoo.model.enums.EnumRegion;
import com.nanoo.model.enums.EnumTitle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author nanoo
 * @create 28/09/2019 - 11:28
 */
public class HandlingEnumValues {
    
    private HandlingEnumValues() {
    }
    
    /**
     * This method return a list of string with all abbreviation contained in enum
     *
     * @return a list of string
     */
    public static List<String> getEnumTitleStringValues (){
        EnumTitle[] listTitle = EnumTitle.values();
        List<String> listTitleStringValues = new ArrayList<>();
        
        for (EnumTitle enumTitle : listTitle){
            listTitleStringValues.add(enumTitle.getAbbreviation());
        }
        
        return  listTitleStringValues;
    }
    
    /**
     * This method return a list of string with all abbreviation contained in enum
     *
     * @return a list of string
     */
    public static List<String> getEnumRegionStringValues (){
        EnumRegion[] listRegion = EnumRegion.values();
        List<String> listRegionStringValues = new ArrayList<>();
        
        for (EnumRegion enumRegion : listRegion){
            listRegionStringValues.add(enumRegion.getAbbreviation());
        }
        
        return  listRegionStringValues;
    }
    
    /**
     * This method return a list of string with all abbreviation contained in enum
     *
     * @return a list of string
     */
    public static List<String> getEnumRatingStringValues (){
        EnumRating[] listRating = EnumRating.values();
        List<String> listRatingStringValues = new ArrayList<>();
        
        for (EnumRating enumRating : listRating){
            listRatingStringValues.add(enumRating.getAbbreviation());
        }
        
        return  listRatingStringValues;
    }
    
    /**
     * This method return the level value associated to the abbreviation in enum
     *
     * @return the level value
     */
    public static int getEnumRatingLevelFromAbbreviationValue (String abbreviation){
        EnumRating[] listRating = EnumRating.values();
        Map<Integer,String> listRatingLevelAndAbbreviationValues = new HashMap<>();
        
        for (EnumRating enumRating : listRating){
            listRatingLevelAndAbbreviationValues.put(enumRating.getLevel(),enumRating.getAbbreviation());
        }
        
        for ( Map.Entry<Integer,String> entry : listRatingLevelAndAbbreviationValues.entrySet()){
            if (entry.getValue().equals(abbreviation)){

                return entry.getKey();
            }
        }
    
        return 0;
    }
    
    /**
     * This method find the level value associated to the abbreviation in the EnumRating.
     *
     * @param rating abbreviation picked up in form
     * @return level value associated
     */
    public static int getLevelOfRatingAbbreviation(String rating) {
        
        return getEnumRatingLevelFromAbbreviationValue(rating);
        
    }
    
    /**
     * This method return a list of string with all abbreviation contained in enum
     *
     * @return a list of string
     */
    public static List<String> getEnumConditionStringValues (){
        EnumCondition[] listCondition = EnumCondition.values();
        List<String> listConditionStringValues = new ArrayList<>();
        
        for (EnumCondition enumCondition : listCondition){
            listConditionStringValues.add(enumCondition.getAbbreviation());
        }
        
        return  listConditionStringValues;
    }
}
