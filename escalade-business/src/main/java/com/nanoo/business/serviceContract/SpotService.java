package com.nanoo.business.serviceContract;

import com.nanoo.business.dto.SectorDTO;
import com.nanoo.business.dto.SiteDTO;
import com.nanoo.business.dto.WayDTO;

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
     * @param siteDTO
     * @param accountId
     * @return
     */
    void saveSite(SiteDTO siteDTO, int accountId);
    
    /**
     * TODO
     * @param siteId
     * @return
     */
    List<SectorDTO> searchSectorBySiteId(int siteId);
    
    /**
     *
     * @param sectorDTO
     * @param accountId
     */
    void saveSector(SectorDTO sectorDTO, String siteId,  int accountId);
    
    /**
     *
     * @param wayDTO
     * @param sectorId
     * @param accountId
     */
    void saveWay(WayDTO wayDTO, String sectorId, int accountId);
    
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
}
