package com.nanoo.business.serviceContract;

import com.nanoo.model.entities.Account;

import java.util.Map;

/**
 * @author nanoo
 * @create 11/09/2019 - 17:36
 */
public interface AccountService {
    
    Map<String,String> getErrors();
    String getResult();
    
    /**
     *
     * @param account
     * @return
     */
    Account saveAccountTestMVC(Account account);
    
    /**
     * This method get Http request, take parameters values of it and call some methods for data process.
     * Then call the consumer layer to check if the user is registered
     * @param account TODO
     * @return true if the user is registered
     */
    Account searchRegisteredAccount(Account account);
}
