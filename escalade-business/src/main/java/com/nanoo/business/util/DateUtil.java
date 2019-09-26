package com.nanoo.business.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author nanoo
 * @create 24/09/2019 - 16:58
 */
public class DateUtil {
    
    private static final String FORMAT_DATE = "dd/MM/yyyy HH:mm:ss";
    
    /**
     * This method return the current date and time
     * @return current date and time in a String
     */
    public String getCurrentDateTime() {
        DateTime date = new DateTime();
        DateTimeFormatter formatter = DateTimeFormat.forPattern( FORMAT_DATE );
        return date.toString( formatter );
    }
    
}
