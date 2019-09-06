package com.nanoo.consumer.repoImpl.user;

import com.nanoo.consumer.repoContrat.user.AccountRepository;
import com.nanoo.model.entities.user.Account;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author nanoo
 * @create 04/09/2019 - 11:02
 */
@Repository
public class AccountRepositoryImpl implements AccountRepository {
    
    @Override
    public <S extends Account> S save(S entity) {
        System.out.println("test entrée couche consumer");
        return null;
    }
    
    @Override
    public <S extends Account> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }
    
    @Override
    public Optional<Account> findById(Integer integer) {
        return Optional.empty();
    }
    
    @Override
    public boolean existsById(Integer integer) {
        return false;
    }
    
    @Override
    public Iterable<Account> findAll() {
        return null;
    }
    
    @Override
    public Iterable<Account> findAllById(Iterable<Integer> integers) {
        return null;
    }
    
    @Override
    public long count() {
        return 0;
    }
    
    @Override
    public void deleteById(Integer integer) {
    
    }
    
    @Override
    public void delete(Account entity) {
    
    }
    
    @Override
    public void deleteAll(Iterable<? extends Account> entities) {
    
    }
    
    @Override
    public void deleteAll() {
    
    }
}
