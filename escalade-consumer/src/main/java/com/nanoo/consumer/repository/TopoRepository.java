package com.nanoo.consumer.repository;

import com.nanoo.model.entities.Topo;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author nanoo
 * @create 04/09/2019 - 17:53
 */
@Repository
public interface TopoRepository extends PagingAndSortingRepository<Topo,Integer> {
    
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
     * This method find all topos posted by a particular userId.
     *
     * @param accountID id of user
     * @param sort way to sort topos
     * @return a list of topos if exist
     */
    List<Topo> findAllByIdAccount (Integer accountID, Sort sort);
    
    /**
     * This method search the id of the owner of a particular Topo
     *
     * @param topoId id of topo
     * @return the id of the owner of the topo
     */
    @Query(value = "SELECT t.id_account FROM topo t WHERE t.id = :topoId",
           nativeQuery = true)
    Integer getAccountIdByTopoId(@Param("topoId") Integer topoId);
    
}
            