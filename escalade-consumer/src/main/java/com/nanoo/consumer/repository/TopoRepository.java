package com.nanoo.consumer.repository;

import com.nanoo.model.entities.Topo;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author nanoo
 * @create 04/09/2019 - 17:53
 */
@Repository
public interface TopoRepository extends CrudRepository<Topo,Integer> {
    
    /**
     * This method find all topos in DB who match with criteria passed in parameter.
     * It use a custom query request.
     *
     * @param region region of topo
     * @param lendable is the topo free to lend
     * @return a list of topos who match with criteria
     */
    @Query(value = "SELECT distinct t.* FROM topo t " +
            "WHERE (:region = 'all' OR t.region = :region) " +
            "AND (:lendable = false OR t.is_lendable = :lendable)" +
            "AND t.date_of_publication >= :sinceDate",
            nativeQuery = true)
    List<Topo> findAllByFilter (@Param("region") String region, @Param("lendable") boolean lendable,
                                @Param("sinceDate")Date sinceDate);
    
    /**
     * This method find all topos contained in DB and sort them
     *
     * @param sort way to sort topos
     * @return all topos contained in DB
     */
    Iterable<Topo> findAll(Sort sort);
}
