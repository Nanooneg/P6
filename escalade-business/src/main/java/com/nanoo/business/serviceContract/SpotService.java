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
    
    /**
     * This method save a site in DB
     *
     * @param siteDTO site to save
     */
    void saveSite(SiteDTO siteDTO);
    
    /**
     * This method delete a site from DB
     *
     * @param siteId id of site to delete
     */
    void deleteSiteWithId(int siteId);
    
    /**
     * This method save a sector in DB
     *
     * @param sectorDTO sector to save
     */
    void saveSector(SectorDTO sectorDTO);
    
    /**
     * This method delete a sector from DB
     *
     * @param sectorId id of sector to delete
     */
    void deleteSectorWithId(int sectorId);
    
    /**
     * This method save a way in DB
     *
     * @param wayDTO way to save
     */
    void saveWay(WayDTO wayDTO);
    
    /**
     * This method delete a way from DB
     *
     * @param wayId id of way to delete
     */
    void deleteWayWithId(int wayId);
    
    /**
     * This method search all sites in DB
     *
     * @return list of site
     */
    List<SiteDTO> findAllSite();
    
    /**
     * This method search a distinct site in DB, or a sector/way contained in a particular site
     *
     * @param siteId id of site searched
     * @return the site searched if exist
     */
    SiteDTO searchSiteById (int siteId);
    
    /**
     * This method search site who match with criteria
     * contained in object {@code filter}
     *
     * @param filter object with search criteria as attributs
     * @return a list of sites who match with criteria if exist
     */
    List<SiteDTO> searchSiteByFilter(SearchFilter filter);
    
    /**
     * This method search the id of a site who contains
     * a particular sector
     *
     * @param sectorId id of the sector contained in the searched site
     * @return the id of the searched site
     */
    int getSiteIdWithSectorId(String sectorId);
    
    /**
     * This method search a distinct sector in DB
     *
     * @param sectorID id of sector searched
     * @return the sector searched if exist
     */
    SectorDTO searchSectorById(int sectorID);
    
    /**
     * This method search all sectors contained in a particular site.
     *
     * @param siteId id of the site in that we are looking for sectors.
     * @return a list of sector contained in the site if exist
     */
    List<SectorDTO> searchSectorBySiteId(Integer siteId);
    
    /**
     * This method search a distinct way in DB
     *
     * @param wayID id of way searched
     * @return the way searched if exist
     */
    WayDTO searchWayById(int wayID);
    
    /**
     * This method search all ways contained in a particular sector.
     * It could have to search in many sectors.
     *
     * @param sectorDTOList a list of sector in that we are looking for ways.
     * @return a map with sectorId in key and a list of ways in value
     */
    Map<Integer,List<WayDTO>> searchWayBySectorId(List<SectorDTO> sectorDTOList);
    
    /**
     * This method search site posted by a particular user
     *
     * @param accountId of the user
     * @return a list of site if exist
     */
    List<SiteDTO> searchSiteByAccountId(Integer accountId);
}
