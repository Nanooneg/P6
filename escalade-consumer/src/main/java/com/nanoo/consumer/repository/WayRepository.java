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
    
    /**
     * This method find all ways contained in a particular {@code sector}
     *
     * @param sector sector we are looking ways for
     * @return a list of ways contained in {@code sector} if exist
     */
    List<Way> findAllBySector(Sector sector);
    
}
