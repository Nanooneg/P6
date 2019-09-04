package com.nanoo.consumer.repoImpl.publication;

import com.nanoo.consumer.repoContrat.publication.MessageRepository;
import com.nanoo.model.entities.publication.Message;

import java.util.Optional;

/**
 * @author nanoo
 * @create 04/09/2019 - 18:00
 */
public class MessageRepositoryImpl implements MessageRepository {
    
    @Override
    public <S extends Message> S save(S entity) {
        return null;
    }
    
    @Override
    public <S extends Message> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }
    
    @Override
    public Optional<Message> findById(Integer integer) {
        return Optional.empty();
    }
    
    @Override
    public boolean existsById(Integer integer) {
        return false;
    }
    
    @Override
    public Iterable<Message> findAll() {
        return null;
    }
    
    @Override
    public Iterable<Message> findAllById(Iterable<Integer> integers) {
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
    public void delete(Message entity) {
    
    }
    
    @Override
    public void deleteAll(Iterable<? extends Message> entities) {
    
    }
    
    @Override
    public void deleteAll() {
    
    }
}
