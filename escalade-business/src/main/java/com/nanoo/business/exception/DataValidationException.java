package com.nanoo.business.exception;

/**
 * @author nanoo
 * @create 09/09/2019 - 14:47
 */
public class DataValidationException extends RuntimeException {
    
    /*Constructeurs*/
    public DataValidationException(String message) {
        super(message);
    }
    
    public DataValidationException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public DataValidationException(Throwable cause) {
        super(cause);
    }
    
}


