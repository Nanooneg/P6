package com.nanoo.consumer.repoImpl.publication;

import com.nanoo.consumer.repoContrat.publication.TopoBookingRepository;
import com.nanoo.model.entities.publication.TopoBooking;

import java.util.Optional;

/**
 * @author nanoo
 * @create 04/09/2019 - 18:02
 */
public class TopoBookingRepositoryImpl implements TopoBookingRepository {
    
    @Override
    public <S extends TopoBooking> S save(S entity) {
        return null;
    }
    
    @Override
    public <S extends TopoBooking> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }
    
    @Override
    public Optional<TopoBooking> findById(Integer integer) {
        return Optional.empty();
    }
    
    @Override
    public boolean existsById(Integer integer) {
        return false;
    }
    
    @Override
    public Iterable<TopoBooking> findAll() {
        return null;
    }
    
    @Override
    public Iterable<TopoBooking> findAllById(Iterable<Integer> integers) {
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
    public void delete(TopoBooking entity) {
    
    }
    
    @Override
    public void deleteAll(Iterable<? extends TopoBooking> entities) {
    
    }
    
    @Override
    public void deleteAll() {
    
    }
}
