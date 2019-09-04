package com.nanoo.consumer.repoImpl.publication;

import com.nanoo.consumer.repoContrat.publication.SiteRepository;
import com.nanoo.model.entities.publication.Site;

import java.util.Optional;

/**
 * @author nanoo
 * @create 04/09/2019 - 18:02
 */
public class SiteRepositoryImpl implements SiteRepository {
    
    @Override
    public <S extends Site> S save(S entity) {
        return null;
    }
    
    @Override
    public <S extends Site> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }
    
    @Override
    public Optional<Site> findById(Integer integer) {
        return Optional.empty();
    }
    
    @Override
    public boolean existsById(Integer integer) {
        return false;
    }
    
    @Override
    public Iterable<Site> findAll() {
        return null;
    }
    
    @Override
    public Iterable<Site> findAllById(Iterable<Integer> integers) {
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
    public void delete(Site entity) {
    
    }
    
    @Override
    public void deleteAll(Iterable<? extends Site> entities) {
    
    }
    
    @Override
    public void deleteAll() {
    
    }
}
