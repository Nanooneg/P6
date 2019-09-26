package com.nanoo.business.serviceImpl;

import com.nanoo.business.dto.SectorDTO;
import com.nanoo.business.dto.SiteDTO;
import com.nanoo.business.mapper.SectorMapper;
import com.nanoo.business.mapper.SiteMapper;
import com.nanoo.business.serviceContract.SpotService;
import com.nanoo.business.util.DateUtil;
import com.nanoo.consumer.repository.SectorRepository;
import com.nanoo.consumer.repository.SiteRepository;
import com.nanoo.model.entities.Sector;
import com.nanoo.model.entities.Site;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    
    @Autowired SiteRepository siteRepository;
    @Autowired SectorRepository sectorRepository;
    
    @Autowired SiteMapper siteMapper;
    @Autowired SectorMapper sectorMapper;
    
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
     *
     * @param sectorDTO
     * @param accountId
     */
    @Override
    public void saveSector(SectorDTO sectorDTO, String siteId, int accountId){
        result="";
        dateUtil = new DateUtil();
    
        Sector sector = sectorMapper.fromDtoToSector(sectorDTO);
        sector.setIdSite(Integer.parseInt(siteId));
        sector.setIdAccount(accountId);
        sector.setDateOfCreation(dateUtil.getCurrentDateTime());
        sector.setDateOfUpdate(sector.getDateOfCreation());
        
        sectorRepository.save(sector);
        result = "L'inscription est un succés !";
    }
    
}
