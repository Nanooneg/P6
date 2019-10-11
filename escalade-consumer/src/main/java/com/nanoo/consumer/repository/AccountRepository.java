package com.nanoo.consumer.repository;

import com.nanoo.model.entities.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nanoo
 * @create 01/09/2019 - 16:42
 */
@Repository
public interface AccountRepository extends CrudRepository<Account,Integer> {
    
    /**
     * This method find an account in DB who contain value of {@code mail} in mail field
     *
     * @param mail mail to look for
     * @return first account who contain {@code mail}
     */
    Account findByMail(String mail);
    
}
