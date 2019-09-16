package com.nanoo.business.serviceContract;

import com.nanoo.model.DTO.AccountDTO;

import java.util.Map;

/**
 * @author nanoo
 * @create 11/09/2019 - 17:36
 */
public interface AccountService {
    
    String getResult();
    Map<String,String> getErrors();
    
    /**
     *
     * @param accountDTO
     * @return
     */
    void saveAccountTestMVC(AccountDTO accountDTO);
    
    /**
     * This method get Http request, take parameters values of it and call some methods for data process.
     * Then call the consumer layer to check if the user is registered
     * @param accountDTO TODO
     * @return true if the user is registered
     */
    AccountDTO searchRegisteredAccount(AccountDTO accountDTO);
}
