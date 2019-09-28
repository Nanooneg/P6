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
     *
     * @return
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
     *
     * @return
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
     *
     * @return
     */
    public List<String> getEnumRatingStringValues (){
        EnumRating[] listRating = EnumRating.values();
        List<String> listRatingStringValues = new ArrayList<>();
        
        for (EnumRating enumRating : listRating){
            listRatingStringValues.add(enumRating.getAbbreviation());
        }
        
        return  listRatingStringValues;
    }
    
}
