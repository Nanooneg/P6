package com.nanoo.business.serviceContract;

import com.nanoo.business.dto.SectorDTO;
import com.nanoo.business.dto.SiteDTO;
import com.nanoo.business.dto.WayDTO;
import com.nanoo.business.util.SearchFilter;

import java.util.List;
import java.util.Map;

/**
 * @author nanoo
 * @create 24/09/2019 - 00:04
 */
public interface SpotService {
    
    String getResult();
    Map<String,String> getErrors();
    
    /**
     * TODO
     * @return
     */
    List<SiteDTO> findAllSite();
    
    /**
     *
     * @param siteId
     * @return
     */
    SiteDTO searchSiteById (int siteId);
    
    /**
     * TODO
     * @param sectorID
     * @return
     */
    SectorDTO searchSectorById(int sectorID);
    
    /**
     * TODO
     * @param wayID
     * @return
     */
    WayDTO searchWayById(int wayID);
    
    /**
     * TODO
     * @param siteDTO
     * @return
     */
    void saveSite(SiteDTO siteDTO);
    
    /**
     *
     * @return
     */
    List<SiteDTO> searchSiteByFilter(SearchFilter filter);
    
    /**
     * TODO
     * @param siteId
     * @return
     */
    List<SectorDTO> searchSectorBySiteId(String siteId);
    
    /**
     *
     * @param sectorDTO
     */
    void saveSector(SectorDTO sectorDTO);
    
    /**
     *
     * @param wayDTO
     */
    void saveWay(WayDTO wayDTO);
    
    /**
     *
     * @param sectorId
     * @return
     */
    int getSiteIdWithSectorId(String sectorId);
    
    /**
     *
     * @param sectorDTOList
     * @return
     */
    Map<Integer,List<WayDTO>> searchWayBySectorId(List<SectorDTO> sectorDTOList);
    
    /**
     *
     * @param siteId
     */
    void deleteSiteWithId(int siteId);
    
    /**
     *
     * @param sectorId
     */
    void deleteSectorWithId(int sectorId);
    
    /**
     *
     * @param wayId
     */
    void deleteWayWithId(int wayId);
    
    /**
     *
     * @param siteId
     */
    void changeLabel(int siteId);
}
