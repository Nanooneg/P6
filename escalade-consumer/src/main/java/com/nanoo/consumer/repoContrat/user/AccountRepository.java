package com.nanoo.consumer.repoContrat.user;

import com.nanoo.model.entities.user.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nanoo
 * @create 01/09/2019 - 16:42
 */
@Repository
public interface AccountRepository extends CrudRepository<Account,Integer> {
    
}
