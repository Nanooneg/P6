package com.nanoo.consumer.repoImpl.publication;

import com.nanoo.consumer.repoContrat.publication.WayRepository;
import com.nanoo.model.entities.publication.Way;

import java.util.Optional;

/**
 * @author nanoo
 * @create 04/09/2019 - 18:03
 */
public class WayRepositoryImpl implements WayRepository {
    
    @Override
    public <S extends Way> S save(S entity) {
        return null;
    }
    
    @Override
    public <S extends Way> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }
    
    @Override
    public Optional<Way> findById(Integer integer) {
        return Optional.empty();
    }
    
    @Override
    public boolean existsById(Integer integer) {
        return false;
    }
    
    @Override
    public Iterable<Way> findAll() {
        return null;
    }
    
    @Override
    public Iterable<Way> findAllById(Iterable<Integer> integers) {
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
    public void delete(Way entity) {
    
    }
    
    @Override
    public void deleteAll(Iterable<? extends Way> entities) {
    
    }
    
    @Override
    public void deleteAll() {
    
    }
}
