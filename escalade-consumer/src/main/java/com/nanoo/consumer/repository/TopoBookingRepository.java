package com.nanoo.consumer.repository;

import com.nanoo.model.entities.TopoBooking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nanoo
 * @create 04/09/2019 - 17:54
 */
@Repository
public interface TopoBookingRepository extends CrudRepository<TopoBooking,Integer> {
}
