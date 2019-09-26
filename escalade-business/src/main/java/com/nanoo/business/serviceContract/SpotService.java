package com.nanoo.business.serviceContract;

import com.nanoo.business.dto.SectorDTO;
import com.nanoo.business.dto.SiteDTO;

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
     * TODO
     * @param siteDTO
     * @param accountId
     * @return
     */
    void saveSite(SiteDTO siteDTO, int accountId);
    
    /**
     *
     * @param sectorDTO
     * @param accountId
     */
    void saveSector(SectorDTO sectorDTO, String siteId,  int accountId);
}
