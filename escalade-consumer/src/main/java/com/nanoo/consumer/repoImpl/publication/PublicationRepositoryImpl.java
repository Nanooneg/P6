package com.nanoo.consumer.repoImpl.publication;

import com.nanoo.consumer.repoContrat.publication.PublicationRepository;
import com.nanoo.model.entities.publication.Publication;

import java.util.Optional;

/**
 * @author nanoo
 * @create 04/09/2019 - 18:01
 */
public class PublicationRepositoryImpl implements PublicationRepository {
    
    @Override
    public <S extends Publication> S save(S entity) {
        return null;
    }
    
    @Override
    public <S extends Publication> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }
    
    @Override
    public Optional<Publication> findById(Integer integer) {
        return Optional.empty();
    }
    
    @Override
    public boolean existsById(Integer integer) {
        return false;
    }
    
    @Override
    public Iterable<Publication> findAll() {
        return null;
    }
    
    @Override
    public Iterable<Publication> findAllById(Iterable<Integer> integers) {
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
    public void delete(Publication entity) {
    
    }
    
    @Override
    public void deleteAll(Iterable<? extends Publication> entities) {
    
    }
    
    @Override
    public void deleteAll() {
    
    }
}
