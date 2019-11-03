package com.nanoo.business.serviceContract;

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
    
}
