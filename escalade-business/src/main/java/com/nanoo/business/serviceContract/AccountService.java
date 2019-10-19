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
    
    /**
     * This method search an account in DB.
     *
     * @param idAccount id of account to search
     * @return account if exist
     */
    AccountDTO searchAccountById(int idAccount);
    
    /**
     * This method search in DB if mail is available
     *
     * @param mail mail to compare with DB
     * @return false if mail is already use for another account
     */
    boolean checkMailAvailability(String mail);
    
    /**
     * This method search in DB if mail is available for update
     *
     * @param mail mail to compare with DB
     * @return false if mail is already use for another account
     */
    boolean checkMailAvailabilityForUpdate(String mail, Integer userId);
}
