package com.nanoo.consumer.repoImpl.publication;

import com.nanoo.consumer.repoContrat.publication.SectorRepository;
import com.nanoo.model.entities.publication.Sector;

import java.util.Optional;

/**
 * @author nanoo
 * @create 04/09/2019 - 18:01
 */
public class SectorRepositoryImpl implements SectorRepository {
    
    @Override
    public <S extends Sector> S save(S entity) {
        return null;
    }
    
    @Override
    public <S extends Sector> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }
    
    @Override
    public Optional<Sector> findById(Integer integer) {
        return Optional.empty();
    }
    
    @Override
    public boolean existsById(Integer integer) {
        return false;
    }
    
    @Override
    public Iterable<Sector> findAll() {
        return null;
    }
    
    @Override
    public Iterable<Sector> findAllById(Iterable<Integer> integers) {
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
    public void delete(Sector entity) {
    
    }
    
    @Override
    public void deleteAll(Iterable<? extends Sector> entities) {
    
    }
    
    @Override
    public void deleteAll() {
    
    }
}
