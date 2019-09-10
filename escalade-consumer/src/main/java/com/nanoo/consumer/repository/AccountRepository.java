package com.nanoo.consumer.repository;

import com.nanoo.model.entities.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nanoo
 * @create 01/09/2019 - 16:42
 */
@Repository
public interface AccountRepository extends CrudRepository<Account,Integer> {

    @Query("FROM Account a WHERE a.mail = ?1")
    public List<Account> searchByMail(String mail);
    
    @Query("FROM Account a WHERE a.mail = ?1 and a.password = ?2")
    public Account searchForLoginRequest(String mail, String password);
    
}
