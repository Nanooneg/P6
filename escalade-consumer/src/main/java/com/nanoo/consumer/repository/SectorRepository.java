package com.nanoo.consumer.repository;

import com.nanoo.model.entities.Sector;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nanoo
 * @create 04/09/2019 - 17:52
 */
@Repository
public interface SectorRepository extends CrudRepository<Sector,Integer> {
    
    public List<Sector> findAllByIdSite (Integer idSite);
    
    public Sector findFirstById (Integer id);
    
}
