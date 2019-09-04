package com.nanoo.consumer.repoContrat.publication;

import com.nanoo.model.entities.publication.Message;
import org.springframework.data.repository.CrudRepository;

/**
 * @author nanoo
 * @create 04/09/2019 - 17:49
 */
public interface MessageRepository extends CrudRepository<Message,Integer> {
}
