package com.nanoo.business.serviceContract;

import com.nanoo.model.entities.Account;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author nanoo
 * @create 02/09/2019 - 12:09
 */
public interface RegistrationService {
    
    Map<String,String> getErrors();
    String getResult();
    
    /**
     * This method get Http request, take parameters values of it and call some methods for data process.
     * Then call the consumer layer to save the Account entity.
     * @param req Http request
     */
    Account saveAccount(HttpServletRequest req);
    
    
    /**
     * This method get Http request, take parameters values of it and call some methods for data process.
     * Then call the consumer layer to check if the user is registered
     * @param req Http request
     * @return true if the user is registered
     */
    Account searchRegisteredAccount(HttpServletRequest req);
}
