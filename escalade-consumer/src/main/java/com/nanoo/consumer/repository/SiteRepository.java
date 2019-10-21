package com.nanoo.consumer.repository;

import com.nanoo.model.entities.Sector;
import com.nanoo.model.entities.Site;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nanoo
 * @create 04/09/2019 - 17:52
 */
@Repository
public interface SiteRepository extends PagingAndSortingRepository<Site,Integer> {
    
    /**
     * This method find all sites in DB who match with criteria passed in parameter.
     * It use a custom query request.
     *
     * @param sectorNbrMin minimum of sectors
     * @param region region of site
     * @param isLabelOfficial is the site tagged with the label "Officiel les amis de l'escalade"
     * @param ratingLevel ratingLevel minimum to found in ways contained in sites
     * @return a list of site who match with criteria
     */
    @Query(value = "SELECT distinct s.* FROM Site s " +
                   "INNER JOIN Sector sec ON s.id = sec.id_site " +
                   "INNER JOIN Way w ON sec.id = w.id_sector " +
                   "WHERE (SELECT COUNT(sec.id) FROM Sector sec WHERE sec.id_site = s.id) >= :sectorNbrMin " +
                   "AND (:region = 'all' OR s.region = :region) " +
                   "AND (:isLabelOfficial = false OR s.is_official_label = :isLabelOfficial) " +
                   "AND (w.rating_level <= :ratingLevel)",
           nativeQuery = true)
    List<Site> findAllByFilter (@Param("sectorNbrMin") int sectorNbrMin, @Param("region") String region,
                                @Param("isLabelOfficial") boolean isLabelOfficial, @Param("ratingLevel") int ratingLevel);
    
    /**
     * This method find all sites posted by a particular userId.
     *
     * @param accountID id of user
     * @param sort way to sort sites
     * @return a list of sites if exist
     */
    List<Site> findAllByIdAccount (Integer accountID, Sort sort);
    
    /**
     * This method return a site who contain a particular sector
     *
     * @param sector sector contained in the search site
     * @return the site if exist
     */
    Site findBySectors (Sector sector);
}
