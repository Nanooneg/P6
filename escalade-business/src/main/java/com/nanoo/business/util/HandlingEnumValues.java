package com.nanoo.business.util;

import com.nanoo.model.enums.EnumRating;
import com.nanoo.model.enums.EnumRegion;
import com.nanoo.model.enums.EnumTitle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nanoo
 * @create 28/09/2019 - 11:28
 */
public class HandlingEnumValues {
    
    /**
     * This method return a list of string with all abbreviation contained in enum
     *
     * @return a list of string
     */
    public List<String> getEnumTitleStringValues (){
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
    public List<String> getEnumRegionStringValues (){
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
    public List<String> getEnumRatingStringValues (){
        EnumRating[] listRating = EnumRating.values();
        List<String> listRatingStringValues = new ArrayList<>();
        
        for (EnumRating enumRating : listRating){
            listRatingStringValues.add(enumRating.getAbbreviation());
        }
        
        return  listRatingStringValues;
    }
    
    /**
     * This method return a list of Integer with all level contained in enum
     *
     * @return a list of Integer
     */
    public List<Integer> getEnumRatingLevelValues (){
        EnumRating[] listRating = EnumRating.values();
        List<Integer> listRatingLevelValues = new ArrayList<>();
    
        for (EnumRating enumRating : listRating){
            listRatingLevelValues.add(enumRating.getLevel());
        }
    
        return  listRatingLevelValues;
    }
}
