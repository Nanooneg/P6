package com.nanoo.consumer.repository;

import com.nanoo.model.entities.Publication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nanoo
 * @create 04/09/2019 - 17:51
 */
@Repository
public interface PublicationRepository extends CrudRepository<Publication,Integer> {
}
