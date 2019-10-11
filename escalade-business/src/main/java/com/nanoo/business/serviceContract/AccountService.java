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
     * This method save an account in DB
     *
     * @param accountDTO account to save
     */
    void saveAccount(AccountDTO accountDTO);
    
    /**
     * This method looks for a match in DB
     *
     * @param accountDTO account parameters from form
     * @return full account parameters if exist in DB
     */
    AccountDTO searchRegisteredAccount(AccountDTO accountDTO);
    
    /**
     * This method search an account in DB
     *
     * @param idAccount id of account searched
     * @return account with chosen parameters if exist
     */
    AccountDTO searchAccountLightById(Integer idAccount);
}
