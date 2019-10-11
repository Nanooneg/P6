package com.nanoo.consumer.repository;

import com.nanoo.model.entities.Sector;
import com.nanoo.model.entities.Site;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nanoo
 * @create 04/09/2019 - 17:52
 */
@Repository
public interface SectorRepository extends CrudRepository<Sector,Integer> {
    
    /**
     * This method find all sectors contained in particular {@code site}.
     *
     * @param site site we are looking sectors for
     * @return a list of sector contained in {@code site} if exist
     */
    List<Sector> findAllBySite(Site site);
    
}
