package com.nanoo.business.serviceImpl.user;

import com.nanoo.business.serviceContrat.user.AccountService;
import com.nanoo.consumer.repoContrat.user.AccountRepository;
import com.nanoo.model.entities.user.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author nanoo
 * @create 01/09/2019 - 16:44
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    
    @Autowired
    private AccountRepository accountRepository;
    
    public void saveAccount(Account account){
        System.out.println("test methode");
        System.out.println(account);
        accountRepository.save(account);
        
    }

}
