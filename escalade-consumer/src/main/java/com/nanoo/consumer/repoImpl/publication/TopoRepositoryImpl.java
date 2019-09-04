package com.nanoo.consumer.repoImpl.publication;

import com.nanoo.consumer.repoContrat.publication.TopoRepository;
import com.nanoo.model.entities.publication.Topo;

import java.util.Optional;

/**
 * @author nanoo
 * @create 04/09/2019 - 18:03
 */
public class TopoRepositoryImpl implements TopoRepository {
    
    @Override
    public <S extends Topo> S save(S entity) {
        return null;
    }
    
    @Override
    public <S extends Topo> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }
    
    @Override
    public Optional<Topo> findById(Integer integer) {
        return Optional.empty();
    }
    
    @Override
    public boolean existsById(Integer integer) {
        return false;
    }
    
    @Override
    public Iterable<Topo> findAll() {
        return null;
    }
    
    @Override
    public Iterable<Topo> findAllById(Iterable<Integer> integers) {
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
    public void delete(Topo entity) {
    
    }
    
    @Override
    public void deleteAll(Iterable<? extends Topo> entities) {
    
    }
    
    @Override
    public void deleteAll() {
    
    }
}
