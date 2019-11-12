package com.nanoo.business.serviceImpl;

import com.nanoo.business.dto.SectorDTO;
import com.nanoo.business.dto.SiteDTO;
import com.nanoo.business.dto.WayDTO;
import com.nanoo.business.mapper.SectorMapper;
import com.nanoo.business.mapper.SiteMapper;
import com.nanoo.business.mapper.WayMapper;
import com.nanoo.business.serviceContract.CommentaryService;
import com.nanoo.business.serviceContract.SpotService;
import com.nanoo.business.util.DateUtil;
import com.nanoo.business.util.HandlingEnumValues;
import com.nanoo.business.util.SearchFilter;
import com.nanoo.business.util.UploadUtil;
import com.nanoo.consumer.repository.SectorRepository;
import com.nanoo.consumer.repository.SiteRepository;
import com.nanoo.consumer.repository.WayRepository;
import com.nanoo.model.entities.Sector;
import com.nanoo.model.entities.Site;
import com.nanoo.model.entities.Way;
import com.nanoo.model.enums.EnumRating;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
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
    
    private static final Logger log = LoggerFactory.getLogger(SpotServiceImpl.class);
    
    private static final String SUCCESS_MESS = "L'enregistrement est un succés !";
    private static final String ERROR_MESS = "L'enregistrement est un échec !";
    
    private static final String SITE_ATT = "site";
    
    private static final String DATE_OF_CREATION_FIELD = "dateOfCreation";
    
    private String result;
    private DateUtil dateUtil;
    private UploadUtil uploadUtil;
    private EnumRating enumRating;
    private HandlingEnumValues enumValues;
    
    private CommentaryService commentaryService;
    
    private final SiteRepository siteRepository;
    private final SectorRepository sectorRepository;
    private final WayRepository wayRepository;
    
    private final SiteMapper siteMapper;
    private final SectorMapper sectorMapper;
    private final WayMapper wayMapper;
    
    public SpotServiceImpl(SiteRepository siteRepository, SectorRepository sectorRepository, WayRepository wayRepository,
                           SiteMapper siteMapper, SectorMapper sectorMapper, WayMapper wayMapper, CommentaryService commentaryService) {
        this.siteRepository = siteRepository;
        this.sectorRepository = sectorRepository;
        this.wayRepository = wayRepository;
        this.siteMapper = siteMapper;
        this.sectorMapper = sectorMapper;
        this.wayMapper = wayMapper;
        this.commentaryService = commentaryService;
    }
    
    
    /**
     * This method save a site in DB
     *
     * @param siteDTO site to save
     */
    @Override
    public void saveSite(SiteDTO siteDTO){
        result="";
        dateUtil = new DateUtil();
        uploadUtil = new UploadUtil();
        Site existingSite;
        String oldPicturePath = null;
        
        Site site = siteMapper.fromDtoToSite(siteDTO);
        
        if (siteDTO.getId() != null) {
            Optional<Site> oldSite = siteRepository.findById(siteDTO.getId());
            if (oldSite.isPresent()) {
                existingSite = oldSite.get();
                site.setDateOfCreation(existingSite.getDateOfCreation());
                site.setIdAccount(existingSite.getIdAccount());
                site.setPicturePath(existingSite.getPicturePath());
                site.setSectors(existingSite.getSectors());
                oldPicturePath = site.getPicturePath();
            }
        }else{
            site.setDateOfCreation(new Date());
        }
        
        site.setDateOfUpdate(new Date());
        
        if ((!Objects.equals(site.getPicture().getOriginalFilename(), "")) && site.getPicture() != null){
            site.setPicturePath(uploadUtil.doUpload(site.getPicture(),site.getName(),site.getDateOfUpdate().toString(),SITE_ATT));
            if (!Objects.equals(oldPicturePath, site.getPicturePath()) && oldPicturePath != null) {
                    UploadUtil.eraseOldPicture(oldPicturePath);
            }
        }
    
        try {
            siteRepository.save(site);
            result = SUCCESS_MESS;
        }catch (Exception e){
            result = ERROR_MESS;
        }
    }
    
    /**
     * This method delete a site from DB.
     *
     * @param siteId id of site to delete
     */
    @Override
    public void deleteSiteWithId(int siteId) {
        Optional<Site> site = siteRepository.findById(siteId);
        
        if (site.isPresent()) {
            siteRepository.deleteById(siteId);
            UploadUtil.eraseOldPicture(site.get().getPicturePath());
            commentaryService.deleteCommentByPublicationId(siteId);
        }
    }
    
    /**
     * This method save a sector in DB
     *
     * @param sectorDTO sector to save
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
                sector.setWays(existingSector.getWays());
            }
        }else{
            sector.setDateOfCreation(new Date());
        }
        
        site.ifPresent(sector::setSite);
        sector.setDateOfUpdate(new Date());
        
        try {
            sectorRepository.save(sector);
            result = SUCCESS_MESS;
        }catch (Exception e){
            result = ERROR_MESS;
        }
    }
    
    /**
     * This method delete a sector from DB
     *
     * @param sectorId id of sector to delete
     */
    @Override
    public void deleteSectorWithId(int sectorId) {
        sectorRepository.deleteById(sectorId);
        commentaryService.deleteCommentByPublicationId(sectorId);
    }
    
    /**
     * This method save a way in DB
     *
     * @param wayDTO way to save
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
            way.setDateOfCreation(new Date());
        }
        
        sector.ifPresent(way::setSector);
        way.setRatingLevel(HandlingEnumValues.getLevelOfRatingAbbreviation(way.getRating()));
        way.setDateOfUpdate(new Date());
        
        try {
            wayRepository.save(way);
            result = SUCCESS_MESS;
        }catch (Exception e){
            result = ERROR_MESS;
        }
    }
    
    /**
     * This method delete a way from DB
     *
     * @param wayId id of way to delete
     */
    @Override
    public void deleteWayWithId(int wayId) {
        wayRepository.deleteById(wayId);
        commentaryService.deleteCommentByPublicationId(wayId);
    }
    
    /**
     * This method search all sites in DB
     *
     * @return list of all sites contained in DB
     */
    @Override
    public List<SiteDTO> findAllSite(){
        Iterable<Site> siteIterable = siteRepository.findAll(Sort.by(DATE_OF_CREATION_FIELD));
        List<SiteDTO> siteDTOList = new ArrayList<>();
        
        for (Site site : siteIterable){
            siteDTOList.add(siteMapper.fromSiteToDto(site));
        }
        
        return siteDTOList;
    }
    
    /**
     * This method search site posted by a particular user
     *
     * @param accountId of the user
     * @return a list of site if exist
     */
    @Override
    public List<SiteDTO> searchSiteByAccountId(Integer accountId) {
        Iterable<Site> siteIterable = siteRepository.findAllByIdAccount(accountId, Sort.by(DATE_OF_CREATION_FIELD));
        List<SiteDTO> siteDTOList = new ArrayList<>();
    
        for (Site site : siteIterable){
            siteDTOList.add(siteMapper.fromSiteToDto(site));
        }
    
        return siteDTOList;
    }
    
    /**
     * This method search a distinct site in DB, or a sector/way contained in a particular site
     *
     * @param spotId id of site searched or id of spot contained in site search
     * @return the site searched if exist
     */
    @Override
    public SiteDTO searchSiteById (int spotId){
        Optional<Site> site = siteRepository.findById(spotId);
        
        if (site.isPresent()) {
            Site existingSite = site.get();
            return siteMapper.fromSiteToDto(existingSite);
        }
        
        Optional<Sector> sector = sectorRepository.findById(spotId);
        
        if (sector.isPresent()){
            Site site1 = siteRepository.findBySectors(sector.get());
            return siteMapper.fromSiteToDto(site1);
        }
        
        Optional<Way> way = wayRepository.findById(spotId);
        
        if (way.isPresent()){
            Sector sector1 = sectorRepository.findByWays(way.get());
            Site site2 = siteRepository.findBySectors(sector1);
            return siteMapper.fromSiteToDto(site2);
        }
        
        return null;
    }
    
    /**
     * This method search site who match with criteria
     * contained in object {@code filter}
     *
     * @param filter object with search criteria as attributs
     * @return a list of sites who match with criteria if exist
     */
    @Override
    public List<SiteDTO> searchSiteByFilter(SearchFilter filter) {
        result = "";
        List<Site> siteList;
        
        String fRegion = filter.getRegion();
        int fSectorNbrMin = Integer.parseInt(filter.getSectorNbrMin());
        boolean fOfficialLabel = filter.isOfficialLabel();
        int fRating;
        
        if (filter.getRating().equals("all"))
            fRating = 20;
        else
            fRating = HandlingEnumValues.getEnumRatingLevelFromAbbreviationValue(filter.getRating());
        
        if (filter.getRating().equals("all") && fSectorNbrMin == 0)
            siteList = siteRepository.findAllBySiteRegionAndSiteLabel(fRegion, fOfficialLabel);
        else if(filter.getRating().equals("all"))
            siteList = siteRepository.findAllBySiteRegionAndSiteLabelAndSectorsCount(fRegion, fOfficialLabel, fSectorNbrMin);
        else
            siteList = siteRepository.findAllBySiteRegionAndSiteLabelAndSectorsCountAndWaysRating(fRegion, fOfficialLabel, fSectorNbrMin, fRating);
        
        List<SiteDTO> siteDTOList = new ArrayList<>();
        
        for (Site site : siteList){
            SiteDTO siteDTO = siteMapper.fromSiteToDto(site);
            siteDTOList.add(siteDTO);
        }
        
        if (siteDTOList.isEmpty())
            result = "Aucun site ne correspond à vos critères";
        else if (siteDTOList.size() == 1)
            result = siteDTOList.size() + " site correspond à vos critères";
        else
            result = siteDTOList.size() + " sites correspondent à vos critères";
            
        return siteDTOList;
    }
    
    /**
     * This method search a distinct sector in DB
     *
     * @param sectorID id of sector searched
     * @return the sector searched if exist
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
     * This method search all sectors contained in a particular site.
     *
     * @param siteId id of the site in that we are looking for sectors.
     * @return a list of sector contained in the site if exist
     */
    @Override
    public List<SectorDTO> searchSectorBySiteId(Integer siteId){
        Optional<Site> site = siteRepository.findById(siteId);
        Site existingSite = null;
        if (site.isPresent()) {
            existingSite = site.get();
        }
        
        List<Sector> sectorList = sectorRepository.findAllBySite(existingSite, Sort.by(DATE_OF_CREATION_FIELD));
        List<SectorDTO> sectorDTOList = new ArrayList<>();
        
        for (Sector sector : sectorList){
            sectorDTOList.add(sectorMapper.fromSectorToDto(sector));
        }
        
        return sectorDTOList;
    }
    
    /**
     * This method search a distinct way in DB
     *
     * @param wayID id of way searched
     * @return the way searched if exist
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
     * This method search all ways contained in a particular sector.
     * It could have to search in many sectors.
     *
     * @param sectorDTOList a list of sector in that we are looking for ways.
     * @return a map with sectorId in key and a list of ways in value
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
            
            List<Way> wayList = wayRepository.findAllBySector(existingSector, Sort.by(DATE_OF_CREATION_FIELD));
            List<WayDTO> wayDTOList = new ArrayList<>();
            
            for (Way way : wayList){
               wayDTOList.add(wayMapper.fromWayToDto(way));
            }
            
            wayDtoListBySectorId.put(sectorDTO.getId(),wayDTOList);
        }
        
        return wayDtoListBySectorId;
    }
}
