package com.nanoo.consumer.repository;

import com.nanoo.model.entities.Topo;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

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
    
    /**
     * This method find all topos posted by a particular userId.
     *
     * @param accountID id of user
     * @param sort way to sort topos
     * @return a list of topos if exist
     */
    List<Topo> findAllByIdAccount (Integer accountID, Sort sort);
    
    /**
     * This method find all topos posted by a particular userId.
     *
     * @param accountId id of user
     * @return a list of topos if exist
     */
    List<Topo> findAllByIdAccount(Integer accountId);
    
    /**
     * This method find all id from topos posted by a particular user.
     *
     * @param accountId id of user
     * @return a list of Integer is topos exist
     */
    @Query(value = "SELECT t.id FROM topo t " +
            "WHERE t.id_account = :accountId",
            nativeQuery = true)
    Set<Integer> getTopoIdByAccountId(@Param("accountId") Integer accountId);
}
