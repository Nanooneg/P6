package com.nanoo.consumer.repoImpl.user;

import com.nanoo.consumer.repoContrat.user.CityRepository;
import com.nanoo.model.entities.user.CityCode;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author nanoo
 * @create 04/09/2019 - 11:01
 */
@Repository
public class CityRepositoryImpl implements CityRepository {
    
    @Override
    public <S extends CityCode> S save(S entity) {
        return null;
    }
    
    @Override
    public <S extends CityCode> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }
    
    @Override
    public Optional<CityCode> findById(Integer integer) {
        return Optional.empty();
    }
    
    @Override
    public boolean existsById(Integer integer) {
        return false;
    }
    
    @Override
    public Iterable<CityCode> findAll() {
        return null;
    }
    
    @Override
    public Iterable<CityCode> findAllById(Iterable<Integer> integers) {
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
    public void delete(CityCode entity) {
    
    }
    
    @Override
    public void deleteAll(Iterable<? extends CityCode> entities) {
    
    }
    
    @Override
    public void deleteAll() {
    
    }
}
