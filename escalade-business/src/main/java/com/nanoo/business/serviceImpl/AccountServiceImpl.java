package com.nanoo.business.serviceImpl;

import com.nanoo.business.serviceContract.AccountService;
import com.nanoo.consumer.repository.AccountRepository;
import com.nanoo.model.entities.Account;
import com.nanoo.model.entities.Address;
import com.nanoo.model.entities.EnumRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
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
    
    public void saveAccount(HttpServletRequest req){
        
        Account account = new Account();
        Address address = new Address();
    
        /*Address*/
        address.setStreetName(req.getParameter("streetName"));
        address.setPostalCode(Integer.parseInt(req.getParameter("postalCode")));
        address.setCity(req.getParameter("city"));
    
        /*Account*/
        account.setTitle(req.getParameter("title"));
        account.setFirstName(req.getParameter("firstName"));
        account.setLastName(req.getParameter("lastName"));
        account.setMail(req.getParameter("mail"));
        account.setAddress(address);
        account.setLogin(req.getParameter("username"));
        account.setPassword(req.getParameter("password"));
        account.setRoleName(EnumRole.USER);
        
        accountRepository.save(account);
        
    }

}
