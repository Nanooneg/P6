package com.nanoo.business.serviceImpl;

import com.nanoo.business.dto.SectorDTO;
import com.nanoo.business.dto.SiteDTO;
import com.nanoo.business.dto.WayDTO;
import com.nanoo.business.mapper.SectorMapper;
import com.nanoo.business.mapper.SiteMapper;
import com.nanoo.business.mapper.WayMapper;
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
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
    
    @Autowired SiteRepository siteRepository;
    @Autowired SectorRepository sectorRepository;
    @Autowired WayRepository wayRepository;
    
    @Autowired SiteMapper siteMapper;
    @Autowired SectorMapper sectorMapper;
    @Autowired WayMapper wayMapper;
    
    private static final String SUCCESS_MESS = "L'inscription est un succés !";
    
    private static final String ABS_PATH = "/resources/";
    private static final String REAL_PATH = "/home/nanoo/dev/static/picture/escalade-pictures/site-pictures/";
    
    /**
     * TODO
     * @return
     */
    @Override
    public List<SiteDTO> findAllSite(){
        Iterable<Site> siteIterable = siteRepository.findAll(Sort.by("dateOfCreation"));
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
     * @param sectorID
     * @return
     */
    @Override
    public SectorDTO searchSectorById(int sectorID){
        Optional<Sector> sector = sectorRepository.findById(sectorID);
    
        if (sector.isPresent()) {
            Sector existingSector = sector.get();
            return sectorMapper.fromSectorToDto(existingSector);
        }
    
        return null;
    }
    
    /**
     * TODO
     * @param wayID
     * @return
     */
    @Override
    public WayDTO searchWayById(int wayID){
        Optional<Way> way = wayRepository.findById(wayID);
        
        if (way.isPresent()) {
            Way existingWay = way.get();
            return wayMapper.fromWayToDto(existingWay);
        }
        
        return null;
    }
    
    /**
     * TODO
     * @param siteDTO
     * @return
     */
    @Override
    public void saveSite(SiteDTO siteDTO){
        result="";
        dateUtil = new DateUtil();
        Site existingSite;
    
        Site site = siteMapper.fromDtoToSite(siteDTO);
        
        if (siteDTO.getId() != null) {
            Optional<Site> oldSite = siteRepository.findById(siteDTO.getId());
            if (oldSite.isPresent()) {
                existingSite = oldSite.get();
                site.setDateOfCreation(existingSite.getDateOfCreation());
                site.setIdAccount(existingSite.getIdAccount());
                site.setPicturePath(existingSite.getPicturePath());
            }
        }else{
            site.setOfficialLabel(false); // label is set false by default.
            site.setDateOfCreation(dateUtil.getCurrentDateTime());
        }
    
        site.setDateOfUpdate(dateUtil.getCurrentDateTime());
        
        if ((!Objects.equals(site.getPicture().getOriginalFilename(), "")) && site.getPicture() != null){
            site.setPicturePath(doUpload(site.getPicture(),site.getName(),site.getDateOfUpdate()));
        }
        
        siteRepository.save(site);
        result = SUCCESS_MESS;
        
    }
    
    /**
     * @param siteId
     */
    @Override
    public void deleteSiteWithId(int siteId) {
        siteRepository.deleteById(siteId);
    }
    
    /**
     * TODO delete this unused methode
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
     * @param filter filter for search
     * @return
     */
    @Override
    public List<SiteDTO> searchSiteByFilter(SearchFilter filter) {
        System.out.println(filter);
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
     */
    @Override
    public void saveSector(SectorDTO sectorDTO){
        result="";
        dateUtil = new DateUtil();
        Sector existingSector;
        
        Sector sector = sectorMapper.fromDtoToSector(sectorDTO);
        Optional<Site> site = siteRepository.findById(sectorDTO.getIdSite());
    
        if (sectorDTO.getId() != null) {
            Optional<Sector> oldSector = sectorRepository.findById(sectorDTO.getId());
            if (oldSector.isPresent()) {
                existingSector = oldSector.get();
                sector.setDateOfCreation(existingSector.getDateOfCreation());
                sector.setIdAccount(existingSector.getIdAccount());
            }
        }else{
            sector.setDateOfCreation(dateUtil.getCurrentDateTime());
        }
        
        site.ifPresent(sector::setSite);
        sector.setDateOfUpdate(dateUtil.getCurrentDateTime());
        
        sectorRepository.save(sector);
        result = SUCCESS_MESS;
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
     */
    @Override
    public void saveWay(WayDTO wayDTO){
        result="";
        dateUtil = new DateUtil();
        Way existingWay;
    
        Way way = wayMapper.fromDtoToWay(wayDTO);
        Optional<Sector> sector = sectorRepository.findById(wayDTO.getIdSector());
    
        if(wayDTO.getId() != null){
            Optional<Way> oldWay = wayRepository.findById(wayDTO.getId());
            if (oldWay.isPresent()){
                existingWay = oldWay.get();
                way.setDateOfCreation(existingWay.getDateOfCreation());
                way.setIdAccount(existingWay.getIdAccount());
            }
        }else{
            way.setDateOfCreation(dateUtil.getCurrentDateTime());
        }
        
        sector.ifPresent(way::setSector);
        way.setDateOfUpdate(dateUtil.getCurrentDateTime());
        
        wayRepository.save(way);
        result = SUCCESS_MESS;
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
    
    /**
     * upload pictures and return their paths
     * @param picture multipart file uploaded
     * @param siteName siteName
     * @param date current date
     * @return file path
     */
    private String doUpload(MultipartFile picture, String siteName, String date) {

        if(!new File(REAL_PATH).exists()){
            new File(REAL_PATH).mkdirs();
        }
        
        try{
            InputStream in = picture.getInputStream();
            
            // server upload
            File serverDestination = new File(REAL_PATH + formatString(date) + "_" + formatString(siteName) + ".jpg");
            FileUtils.copyInputStreamToFile(in,serverDestination);
            
            in.close();
        }catch (IOException e){
            System.out.println(e.getMessage()); //TODO logger
        }
        System.out.println(REAL_PATH + formatString(date) + "_" + formatString(siteName) + ".jpg");
        System.out.println(ABS_PATH + formatString(date) + "_" + formatString(siteName) + ".jpg");
        return ABS_PATH + formatString(date) + "_" + formatString(siteName) + ".jpg";
    }
    
    /**
     * remove some characters from a string
     * @param string
     * @return
     */
    public String formatString (String string){
        return string.replace("/","_").replace(" ","_").replace(":","_");
    }
}
