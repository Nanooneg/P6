package com.nanoo.business.serviceImpl;

import com.nanoo.business.dto.SectorDTO;
import com.nanoo.business.dto.SiteDTO;
import com.nanoo.business.dto.WayDTO;
import com.nanoo.business.mapper.SectorMapper;
import com.nanoo.business.mapper.SiteMapper;
import com.nanoo.business.mapper.WayMapper;
import com.nanoo.business.serviceContract.AccountService;
import com.nanoo.business.serviceContract.SpotService;
import com.nanoo.business.util.DateUtil;
import com.nanoo.business.util.SearchFilter;
import com.nanoo.consumer.repository.SectorRepository;
import com.nanoo.consumer.repository.SiteRepository;
import com.nanoo.consumer.repository.WayRepository;
import com.nanoo.model.entities.Sector;
import com.nanoo.model.entities.Site;
import com.nanoo.model.entities.Way;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author nanoo
 * @create 24/09/2019 - 00:02
 */
@Service
@Transactional
@Data
public class SpotServiceImpl implements SpotService {
    
    private String result;
    private Map<String,String> errors;
    
    private DateUtil dateUtil;
    @Autowired AccountService accountService;
    
    @Autowired SiteRepository siteRepository;
    @Autowired SectorRepository sectorRepository;
    @Autowired WayRepository wayRepository;
    
    @Autowired SiteMapper siteMapper;
    @Autowired SectorMapper sectorMapper;
    @Autowired WayMapper wayMapper;
    
    /**
     * TODO
     * @return
     */
    @Override
    public List<SiteDTO> findAllSite(){
        Iterable<Site> siteIterable = siteRepository.findAll();
        List<SiteDTO> siteDTOList = new ArrayList<>();
    
        for (Site site : siteIterable){
            siteDTOList.add(siteMapper.fromSiteToDto(site));
        }
        
        return siteDTOList;
    }
    
    
    /**
     * TODO
     * @param siteId
     * @return
     */
    @Override
    public SiteDTO searchSiteById (int siteId){
        Optional<Site> site = siteRepository.findById(siteId);
        
        if (site.isPresent()) {
            Site existingSite = site.get();
            return siteMapper.fromSiteToDto(existingSite);
        }
        
        return null;
    }
    
    /**
     * TODO
     * @param siteDTO
     * @param accountId
     * @return
     */
    @Override
    public void saveSite(SiteDTO siteDTO, int accountId){
        result="";
        dateUtil = new DateUtil()
;
        Site site = siteMapper.fromDtoToSite(siteDTO);
        site.setOfficialLabel(false); // label is set false by default.
        site.setIdAccount(accountId);
        site.setDateOfCreation(dateUtil.getCurrentDateTime());
        site.setDateOfUpdate(site.getDateOfCreation());
        
        siteRepository.save(site);
        result = "L'inscription est un succés !";
        
    }
    
    /**
     * @param siteId
     */
    @Override
    public void deleteSiteWithId(int siteId) {
        siteRepository.deleteById(siteId);
    }
    
    /**
     * @param siteId
     */
    @Override
    public void changeLabel(int siteId) {
        Optional<Site> site = siteRepository.findById(siteId);
        
        if (site.isPresent()){
            Site existingSite = site.get();
    
            if (existingSite.isOfficialLabel()){
                existingSite.setOfficialLabel(false);
                siteRepository.save(existingSite);
            }else if(!existingSite.isOfficialLabel()) {
                existingSite.setOfficialLabel(true);
                siteRepository.save(existingSite);
            }
        }
    }
    
    /**
     * TODO
     * @param filter
     * @return
     */
    @Override
    public List<SiteDTO> searchSiteByFilter(SearchFilter filter) {
        String fRegion = filter.getRegion();
        int fSectorNbrMin = Integer.parseInt(filter.getSectorNbrMin());
        boolean fOfficialLabel = filter.isOfficialLabel();
        String fRating = filter.getRating();
        
        List<Site> siteList = siteRepository.findAllByFilter(fSectorNbrMin,fRegion,fOfficialLabel,fRating);
        List<SiteDTO> siteDTOList = new ArrayList<>();
        
        for (Site site : siteList){
            SiteDTO siteDTO = siteMapper.fromSiteToDto(site);
            siteDTOList.add(siteDTO);
        }
        
        return siteDTOList;
    }
    
    /**
     * TODO
     * @param siteId
     * @return
     */
    @Override
    public List<SectorDTO> searchSectorBySiteId(String siteId){
        Optional<Site> site = siteRepository.findById(Integer.parseInt(siteId));
        Site existingSite = null;
        if (site.isPresent()) {
            existingSite = site.get();
        }
        
        List<Sector> sectorList = sectorRepository.findAllBySite(existingSite);
        List<SectorDTO> sectorDTOList = new ArrayList<>();
    
        for (Sector sector : sectorList){
            sectorDTOList.add(sectorMapper.fromSectorToDto(sector));
        }
        
        return sectorDTOList;
    }
    
    /**
     *
     * @param sectorDTO
     * @param accountId
     */
    @Override
    public void saveSector(SectorDTO sectorDTO, String siteId, int accountId){
        result="";
        dateUtil = new DateUtil();
        
        
        Sector sector = sectorMapper.fromDtoToSector(sectorDTO);
        Optional<Site> site = siteRepository.findById(Integer.parseInt(siteId));
        site.ifPresent(sector::setSite);
        sector.setIdAccount(accountId);
        sector.setDateOfCreation(dateUtil.getCurrentDateTime());
        sector.setDateOfUpdate(sector.getDateOfCreation());
        
        sectorRepository.save(sector);
        result = "L'inscription est un succés !";
    }
    
    /**
     * @param sectorId
     */
    @Override
    public void deleteSectorWithId(int sectorId) {
        
        sectorRepository.deleteById(sectorId);
    
    }
    
    /**
     * TODO
     * @param wayDTO
     * @param sectorId
     * @param accountId
     */
    @Override
    public void saveWay(WayDTO wayDTO, String sectorId, int accountId){
        result="";
        dateUtil = new DateUtil();
    
        Way way = wayMapper.fromDtoToWay(wayDTO);
        Optional<Sector> sector = sectorRepository.findById(Integer.parseInt(sectorId));
        sector.ifPresent(way::setSector);
        way.setIdAccount(accountId);
        way.setDateOfCreation(dateUtil.getCurrentDateTime());
        way.setDateOfUpdate(way.getDateOfCreation());
        
        wayRepository.save(way);
        result = "L'inscription est un succés !";
    }
    
    /**
     * @param wayId
     */
    @Override
    public void deleteWayWithId(int wayId) {
    
        wayRepository.deleteById(wayId);
        
    }
    
    /**
     * @param sectorId
     *
     * @return
     */
    @Override
    public int getSiteIdWithSectorId(String sectorId) {
        
        Sector sector = sectorRepository.findFirstById(Integer.parseInt(sectorId));
        
        return sector.getSite().getId();
    }
    
    /**
     * @param sectorDTOList
     *
     * @return
     */
    @Override
    public Map<Integer,List<WayDTO>> searchWayBySectorId(List<SectorDTO> sectorDTOList) {
    
        Map<Integer,List<WayDTO>> wayDtoListBySectorId = new HashMap<>();
        
        for (SectorDTO sectorDTO : sectorDTOList){
            Optional<Sector> sector = sectorRepository.findById(sectorDTO.getId());
            Sector existingSector = null;
            if (sector.isPresent()) {
                existingSector = sector.get();
            }
            
            List<Way> wayList = wayRepository.findAllBySector(existingSector);
            List<WayDTO> wayDTOList = new ArrayList<>();
            
            for (Way way : wayList){
               wayDTOList.add(wayMapper.fromWayToDto(way));
            }
            
            wayDtoListBySectorId.put(sectorDTO.getId(),wayDTOList);
        }
        
        return wayDtoListBySectorId;
    }
}
