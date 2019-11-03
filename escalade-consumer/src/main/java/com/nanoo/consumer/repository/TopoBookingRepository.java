package com.nanoo.consumer.repository;

import com.nanoo.model.entities.TopoBooking;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author nanoo
 * @create 04/09/2019 - 17:54
 */
@Repository
public interface TopoBookingRepository extends PagingAndSortingRepository<TopoBooking,Integer> {
    
    /**
     * This method find all topobooking in DB who concern some topos
     *
     * @param topoIdList if of topos concerned
     * @param sort way to sort result
     * @return a list of topobooking if exist findAllTopoBookingByIdTopo
     */
    List<TopoBooking> findAllTopoBookingByIdTopo (Set<Integer> topoIdList, Sort sort);
    
    /**
     * This method find all topobooking in DB for a particular user
     *
     * @param accountId id of the user
     * @return a list of topobooking if exist
     */
    List<TopoBooking> findAllByIdAccountBorrower (Integer accountId);
    
    /**
     * TODO
     *
     * @param accountId
     * @return
     */
    List<TopoBooking> findAllByIdAccountOwner (Integer accountId);
    
    /**
     * This method remove topoBooking who expire
     *
     * @param currentDate current date to compare with dateOfExpiry
     */
    @Modifying
    @Query(value = "DELETE FROM topobooking tb WHERE tb.date_of_expiry < :currentDate",nativeQuery = true)
    void deleteAllOldTopoBooking(@Param("currentDate") Date currentDate);
    
    /**
     * This method search a topobooking in DB with a particular couple user/topo
     *
     * @param accountId id of user
     * @param topoId id of topo
     * @return topobooking if exist
     */
    TopoBooking findByIdAccountBorrowerAndIdTopo (Integer accountId, Integer topoId);
}
