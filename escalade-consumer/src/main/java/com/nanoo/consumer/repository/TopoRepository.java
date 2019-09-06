package com.nanoo.consumer.repository;

import com.nanoo.model.entities.Topo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nanoo
 * @create 04/09/2019 - 17:53
 */
@Repository
public interface TopoRepository extends CrudRepository<Topo,Integer> {
}
