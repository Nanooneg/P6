package com.nanoo.business.serviceContract;

import com.nanoo.business.dto.TopoBookingDTO;

import java.util.List;

/**
 * @author nanoo
 * @create 03/11/2019 - 13:37
 */
public interface TopoBookingService {
    
    /**
     * This method save a topoBooking in DB.
     *
     * @param accountId id of borrower
     * @param topoId id of topo who's lended
     */
    void saveTopoBooking(Integer accountId, Integer topoId);
    
    /**
     * This method search all topobooking who concern particular Topo owner user but return only pending status topobooking.
     *
     * @param accountId id of user concerned
     * @return list of topobooking with pending status if exist
     */
    List<TopoBookingDTO> searchAllTopoBookingByIdOwnerWithPendingStatus(Integer accountId);
    
    /**
     * This method search all topobooking who concern particular user.
     *
     * @param accountId id of user
     * @return list of topoBooking if exist
     */
    List<TopoBookingDTO> searchAllTopoBookingByIdBorrower(int accountId);
    
    /**
     * This method search all topobooking who concern particular user.
     *
     * @param accountId id of user
     * @return list of topoBooking if exist
     */
    List<TopoBookingDTO> searchAllTopoBookingByIdOwner(int accountId);
    
    /**
     * This method change topobooking status and if needed topo Lendable status too.
     *
     * @param userId id of user who answer the request
     * @param topoBookingId id of topobooking the status will be changed
     * @param answer answer of user
     */
    void changeStatus(String userId, String topoBookingId, String answer);
    
    /**
     * This method delete a topoBooking in DB
     *
     * @param topoBookingId id of topobooking to delete
     */
    void deleteTopoBooking(int topoBookingId);
    
    /**
     * This method search if a topoBooking exist in db
     *
     * @param accountId id of user
     * @param topoId id of topo
     * @return true if exist
     */
    boolean checkTopoBookingAskRequest(String accountId, String topoId);
    
}
