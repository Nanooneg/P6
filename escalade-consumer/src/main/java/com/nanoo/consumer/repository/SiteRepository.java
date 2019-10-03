package com.nanoo.consumer.repository;

import com.nanoo.model.entities.Site;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nanoo
 * @create 04/09/2019 - 17:52
 */
@Repository
public interface SiteRepository extends CrudRepository<Site,Integer> {
    
    @Query(value = "SELECT distinct s.* FROM Site s " +
                   "INNER JOIN Sector sec ON s.id = sec.id_site " +
                   "INNER JOIN Way w ON sec.id = w.id_sector " +
                   "WHERE (SELECT COUNT(sec.id) FROM Sector sec WHERE sec.id_site = s.id) >= :sectorNbrMin " +
                   "AND (:region = 'all' OR s.region = :region) " +
                   "AND (:isLabelOfficial = false OR s.is_official_label = :isLabelOfficial) " +
                   "AND (:rating = 'all' OR w.rating = :rating)",
           nativeQuery = true)
    List<Site> findAllByFilter (@Param("sectorNbrMin") int sectorNbrMin, @Param("region") String region,
                                @Param("isLabelOfficial") boolean isLabelOfficial, @Param("rating") String rating);
        
}
