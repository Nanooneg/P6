package com.nanoo.consumer.repository;

import com.nanoo.model.entities.Sector;
import com.nanoo.model.entities.Way;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nanoo
 * @create 04/09/2019 - 17:55
 */
@Repository
public interface WayRepository extends CrudRepository<Way,Integer> {
    
    public List<Way> findAllBySector(Sector sector);
    
}
