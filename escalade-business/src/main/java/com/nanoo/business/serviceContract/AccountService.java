package com.nanoo.business.serviceContract;

import com.nanoo.business.dto.AccountDTO;

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
    void saveAccount(AccountDTO accountDTO);
    
    /**
     * This method get Http request, take parameters values of it and call some methods for data process.
     * Then call the consumer layer to check if the user is registered
     * @param accountDTO TODO
     * @return true if the user is registered
     */
    AccountDTO searchRegisteredAccount(AccountDTO accountDTO);
    
    /**
     * TODO
     * @param idAccount
     * @return
     */
    AccountDTO searchAccountLightById(Integer idAccount);
}
