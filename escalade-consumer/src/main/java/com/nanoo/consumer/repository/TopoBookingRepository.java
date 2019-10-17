package com.nanoo.consumer.repository;

import com.nanoo.model.entities.TopoBooking;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
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
public interface TopoBookingRepository extends CrudRepository<TopoBooking,Integer> {
    
    /**
     * This method find all topobooking in DB who concern some topos
     *
     * @param topoIdList if of topos concerned
     * @return a list of topobooking if exist
     */
    List<TopoBooking> findAllTopoBookingByIdTopo (Set<Integer> topoIdList);
    
    /**
     * This method find all topobooking in DB for a particular user
     *
     * @param accountId id of the user
     * @return a list of topobooking if exist
     */
    List<TopoBooking> findAllByIdAccountBorrower (Integer accountId);
    
    /**
     * This method remove topoBooking who expire
     *
     * @param currentDate current date to compare with dateOfExpiry
     */
    @Modifying
    @Query(value = "DELETE FROM topobooking tb WHERE tb.date_of_expiry < :currentDate",nativeQuery = true)
    void deleteAllOldTopoBooking(@Param("currentDate") Date currentDate);
}
