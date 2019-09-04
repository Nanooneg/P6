package com.nanoo.consumer.repoImpl.user;

import com.nanoo.consumer.repoContrat.user.AdressRepository;
import com.nanoo.model.entities.user.Address;

import java.util.Optional;

/**
 * @author nanoo
 * @create 04/09/2019 - 17:46
 */
public class AdressRepositoryImpl implements AdressRepository {
    
    @Override
    public <S extends Address> S save(S entity) {
        return null;
    }
    
    @Override
    public <S extends Address> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }
    
    @Override
    public Optional<Address> findById(Integer integer) {
        return Optional.empty();
    }
    
    @Override
    public boolean existsById(Integer integer) {
        return false;
    }
    
    @Override
    public Iterable<Address> findAll() {
        return null;
    }
    
    @Override
    public Iterable<Address> findAllById(Iterable<Integer> integers) {
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
    public void delete(Address entity) {
    
    }
    
    @Override
    public void deleteAll(Iterable<? extends Address> entities) {
    
    }
    
    @Override
    public void deleteAll() {
    
    }
}
