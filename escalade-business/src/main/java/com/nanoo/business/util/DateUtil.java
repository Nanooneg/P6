package com.nanoo.business.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Calendar;
import java.util.Date;

/**
 * @author nanoo
 * @create 24/09/2019 - 16:58
 */
public class DateUtil {
    
    private static final String FORMAT_DATE = "dd/MM/yyyy HH:mm:ss";
    
    private static final String HALF_YEAR_ATT = "HY";
    private static final String ONE_YEAR_ATT = "1Y";
    private static final String TWO_YEAR_ATT = "2Y";
    private static final String FIVE_YEAR_ATT = "5Y";
    private static final String TEN_YEAR_ATT = "10Y";
    
    /**
     * This method return the current date and time
     *
     * @return current date and time in a String
     */
    public String getCurrentDateTime() {
        DateTime date = new DateTime();
        DateTimeFormatter formatter = DateTimeFormat.forPattern( FORMAT_DATE );
        
        return date.toString( formatter );
    }
    
    /**
     * This method calculate a date from current date with a period
     *
     * @param period time to remove to current date
     * @return a date
     */
    public Date calculateDate(String period) {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        
        switch (period){
            case HALF_YEAR_ATT :
                c.add(Calendar.MONTH,-6);
                return c.getTime();
            case ONE_YEAR_ATT :
                c.add(Calendar.YEAR,-1);
                return c.getTime();
            case TWO_YEAR_ATT :
                c.add(Calendar.YEAR,-2);
                return c.getTime();
            case FIVE_YEAR_ATT :
                c.add(Calendar.YEAR,-5);
                return c.getTime();
            case TEN_YEAR_ATT :
                c.add(Calendar.YEAR,-10);
                return c.getTime();
            default:
                c.add(Calendar.YEAR,-100);
                return c.getTime();
        }
    }
}
