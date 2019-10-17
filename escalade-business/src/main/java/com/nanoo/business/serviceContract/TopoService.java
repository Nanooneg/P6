package com.nanoo.business.serviceContract;

import com.nanoo.business.dto.TopoBookingDTO;
import com.nanoo.business.dto.TopoDTO;
import com.nanoo.business.util.SearchFilter;

import java.util.List;

/**
 * @author nanoo
 * @create 24/09/2019 - 00:08
 */
public interface TopoService {
    
    String getResult();
    
    /**
     * This method save a topo in DB.
     *
     * @param topoDTO topo to save.
     */
    void saveTopo (TopoDTO topoDTO);
    
    /**
     * This method delete a topo in DB.
     *
     * @param topoId id of topo to delete
     */
    void deleteTopo(int topoId);
    
    /**
     * This method search all topos in DB.
     *
     * @return list of topos
     */
    List<TopoDTO> findAllTopo();
    
    /**
     * This method search a distinct topo in DB
     *
     * @param topoId id of topo searched
     * @return the topo searched if exist
     */
    TopoDTO searchTopoById(int topoId);
    
    /**
     * This method search topo who match with criteria
     * contained in object {@code filter}
     *
     * @param filter object with search criteria as attributs
     * @return a list of topos who match with criteria if exist
     */
    List<TopoDTO> searchTopoByFilter(SearchFilter filter);
    
    /**
     * This method search topo posted by a particular user
     *
     * @param accountId of the user
     * @return a list of topo if exist
     */
    List<TopoDTO> searchTopoByAccountId(Integer accountId);
    
    /**
     * This method save a topoBooking in DB.
     *
     * @param accountId id of borrower
     * @param topoId id of topo who's lended
     */
    void saveTopoBooking(Integer accountId, Integer topoId);
    
    /**
     * This method search all topobooking who concern particular Topo owner user.
     *
     * @param accountId id of user concerned
     * @return list of topobooking if exist
     */
    List<TopoBookingDTO> searchAllTopoBookingByTopoAccountId(Integer accountId);
    
    /**
     * This method search all topobooking who concern particular vuser.
     *
     * @param accountId id of user
     * @return list of topoBooking if exist
     */
    List<TopoBookingDTO> searchAllTopoBookingByAccountId(int accountId);
    
    /**
     * This method change topobooking status and if needed topo Lendable status too.
     *
     * @param userId id of user who answer the request
     * @param topoBookingId id of topobooking the status will be changed
     * @param answer answer of user
     */
    void changeStatus(String userId, String topoBookingId, String answer);
}
