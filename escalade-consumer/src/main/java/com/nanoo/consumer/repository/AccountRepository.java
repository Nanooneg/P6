package com.nanoo.consumer.repository;

import com.nanoo.model.entities.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author nanoo
 * @create 01/09/2019 - 16:42
 */
@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account,Integer> {
    
    /**
     * This method find an account in DB who contain value of {@code mail} in mail field
     *
     * @param mail mail to look for
     * @return first account who contain {@code mail}
     */
    Account findByMail(String mail);
    
    /**
     * This method return the mail of an account
     *
     * @param id id of the account
     * @return the mail
     */
    @Query(value = "SELECT a.mail FROM account a WHERE a.id = :id", nativeQuery = true)
    String findMailById (@Param("id") Integer id);
    
}
