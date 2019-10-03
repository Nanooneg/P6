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
    
    @Query(value = "SELECT * FROM Site s " +
                   "WHERE (SELECT COUNT(sec.id) FROM Sector sec WHERE sec.id_site = s.id) >= :sectorNbrMin " +
                   "AND (:region = 'all' OR s.region = :region) " +
                   "AND (:isLabelOfficial = false OR s.is_official_label = :isLabelOfficial)",
           nativeQuery = true)
    List<Site> findAllByFilter (@Param("sectorNbrMin") int sectorNbrMin, @Param("region") String region,
                                         @Param("isLabelOfficial") boolean isLabelOfficial);
        
}

// TEST

//@Query(value = "SELECT * FROM Site s WHERE " +
//                   "(SELECT COUNT(sec) FROM Sector sec WHERE sec.id_site = s.id) >= :sectorNbrMin AND " +
//                   "(:region = 'all' OR s.region = :region) AND" +
//                   "(:isLabelOfficial = false OR s.is_official_label = :isLabelOfficial) AND" +
//                   "(:ratingMin = 'all' OR :ratingMin  " +
//                            "(SELECT w.rating FROM Way w WHERE w.id_sector = " +
//                                    "(SELECT sec.id FROM Sector sec WHERE sec.id_site = s.id)))",
//                   nativeQuery = true)

//                   "INNER JOIN Sector sec ON s.id = sec.id_site " +
//                   "INNER JOIN Way w ON sec.id = w.id_sector " +

//(:ratingMin = 'all' OR :ratingMin  IS " +
//                            "(SELECT w.rating FROM Way w WHERE " +
//                                "(SELECT sec.id FROM Sector sec WHERE sec.id_site = s.id) = w.id_sector)