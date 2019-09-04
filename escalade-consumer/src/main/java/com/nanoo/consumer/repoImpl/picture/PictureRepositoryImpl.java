package com.nanoo.consumer.repoImpl.picture;

import com.nanoo.consumer.repoContrat.picture.PictureRepository;
import com.nanoo.model.entities.picture.Picture;

import java.util.Optional;

/**
 * @author nanoo
 * @create 04/09/2019 - 18:04
 */
public class PictureRepositoryImpl implements PictureRepository {
    
    @Override
    public <S extends Picture> S save(S entity) {
        return null;
    }
    
    @Override
    public <S extends Picture> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }
    
    @Override
    public Optional<Picture> findById(Integer integer) {
        return Optional.empty();
    }
    
    @Override
    public boolean existsById(Integer integer) {
        return false;
    }
    
    @Override
    public Iterable<Picture> findAll() {
        return null;
    }
    
    @Override
    public Iterable<Picture> findAllById(Iterable<Integer> integers) {
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
    public void delete(Picture entity) {
    
    }
    
    @Override
    public void deleteAll(Iterable<? extends Picture> entities) {
    
    }
    
    @Override
    public void deleteAll() {
    
    }
}
