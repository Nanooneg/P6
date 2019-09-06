package com.nanoo.consumer.repository;

import com.nanoo.model.entities.Way;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nanoo
 * @create 04/09/2019 - 17:55
 */
@Repository
public interface WayRepository extends CrudRepository<Way,Integer> {
}
