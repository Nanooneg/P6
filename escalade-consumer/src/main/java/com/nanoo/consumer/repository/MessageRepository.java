package com.nanoo.consumer.repository;

import com.nanoo.model.entities.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nanoo
 * @create 04/09/2019 - 17:49
 */
@Repository
public interface MessageRepository extends CrudRepository<Message,Integer> {
}
