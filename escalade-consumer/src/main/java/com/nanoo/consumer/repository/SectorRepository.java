package com.nanoo.consumer.repository;

import com.nanoo.model.entities.Sector;
import com.nanoo.model.entities.Site;
import com.nanoo.model.entities.Way;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nanoo
 * @create 04/09/2019 - 17:52
 */
@Repository
public interface SectorRepository extends PagingAndSortingRepository<Sector,Integer> {
    
    /**
     * This method find all sectors contained in particular {@code site}.
     *
     * @param site site we are looking sectors for
     * @return a list of sector contained in {@code site} if exist
     */
    List<Sector> findAllBySite(Site site);
    
    /**
     * This method return a sector who contain a particular way
     *
     * @param way way contained in the search site
     * @return the sector if exist
     */
    Sector findByWays (Way way);
    
}
