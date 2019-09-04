package com.nanoo.consumer.repoImpl.publication;

import com.nanoo.consumer.repoContrat.publication.CommentaryRepository;
import com.nanoo.model.entities.publication.Commentary;

import java.util.Optional;

/**
 * @author nanoo
 * @create 04/09/2019 - 17:55
 */
public class CommentaryRepositoryImpl implements CommentaryRepository {
    
    @Override
    public <S extends Commentary> S save(S entity) {
        return null;
    }
    
    @Override
    public <S extends Commentary> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }
    
    @Override
    public Optional<Commentary> findById(Integer integer) {
        return Optional.empty();
    }
    
    @Override
    public boolean existsById(Integer integer) {
        return false;
    }
    
    @Override
    public Iterable<Commentary> findAll() {
        return null;
    }
    
    @Override
    public Iterable<Commentary> findAllById(Iterable<Integer> integers) {
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
    public void delete(Commentary entity) {
    
    }
    
    @Override
    public void deleteAll(Iterable<? extends Commentary> entities) {
    
    }
    
    @Override
    public void deleteAll() {
    
    }
}
