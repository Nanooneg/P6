package com.nanoo.webapp.controller;

import com.nanoo.business.dto.*;
import com.nanoo.business.serviceContract.AccountService;
import com.nanoo.business.serviceContract.SpotService;
import com.nanoo.business.util.HandlingEnumValues;
import com.nanoo.business.util.SearchFilter;
import com.nanoo.webapp.util.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author nanoo
 * @create 23/09/2019 - 12:08
 */
@Controller
public class SpotController {
    
    /* Attributes names */
    private static final String ACCOUNT_ATT = "account";
    private static final String ACCOUNT_SESSION_ATT = "accountSession";
    private static final String SPOT_SERV_ATT = "saveSpot";
    private static final String LIST_SITE_ATT = "listSite";
    private static final String MESSAGE_ATT = "message";
    private static final String RATING_ATT = "listRating";
    private static final String REGION_ATT = "listRegion";
    private static final String SEARCH_ATT = "searchAttribut";
    private static final String SITE_ATT = "site";
    private static final String SECTOR_ATT = "sector";
    private static final String SITE_ID_ATT = "siteId";
    private static final String SECTOR_ID_ATT = "sectorId";
    private static final String LIST_SECTOR_ATT = "listSector";
    private static final String WAY_ATT = "way";
    private static final String MAP_WAY_BY_SECTOR_ID_ATT = "wayListBySectorId";
    
    private List<String> listRating = HandlingEnumValues.getEnumRatingStringValues();
    private List<String> listRegion = HandlingEnumValues.getEnumRegionStringValues();
    
    private final SpotService spotService;
    private final AccountService accountService;
    
    @Autowired
    public SpotController(SpotService spotService, AccountService accountService) {
        this.spotService = spotService;
        this.accountService = accountService;
    }
    
    
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
    
    @GetMapping("/climbSpot")
    public String displaySpotPage (Model model){
        
        List<SiteDTO> siteDTOList = spotService.findAllSite();
        model.addAttribute(SEARCH_ATT,new SearchFilter());
        model.addAttribute(RATING_ATT,listRating);
        model.addAttribute(REGION_ATT,listRegion);
        model.addAttribute(LIST_SITE_ATT,siteDTOList);
        
        return Views.SPOT;
    }
    
    @PostMapping("/climbSpot")
    public String displaySpotPageWithResult (@ModelAttribute(SEARCH_ATT) SearchFilter filter, Model model){
        
        List<SiteDTO> siteDTOListResult = spotService.searchSiteByFilter(filter);
        
        model.addAttribute(MESSAGE_ATT, spotService.getResult());
        model.addAttribute(LIST_SITE_ATT, siteDTOListResult);
        model.addAttribute(SEARCH_ATT, filter);
        model.addAttribute(RATING_ATT, listRating);
        model.addAttribute(REGION_ATT, listRegion);
        
        return Views.SPOT;
    }
    
    @GetMapping("/site/{spotId}")
    public String displaySite (@PathVariable String spotId, Model model){
    
        SiteDTO siteDTO = spotService.searchSiteById(Integer.parseInt(spotId));
        AccountDTO accountDTO = accountService.searchAccountLightById(siteDTO.getIdAccount());
        List<SectorDTO> sectorDTOList = spotService.searchSectorBySiteId(siteDTO.getId());
        Map<Integer,List<WayDTO>> wayDTOList = spotService.searchWayBySectorId(sectorDTOList);
        
        model.addAttribute(SITE_ATT, siteDTO);
        model.addAttribute(ACCOUNT_ATT,accountDTO);
        model.addAttribute(LIST_SECTOR_ATT,sectorDTOList);
        model.addAttribute(MAP_WAY_BY_SECTOR_ID_ATT,wayDTOList);
        
        return Views.SITE;
    }
    
    @GetMapping("/user/siteForm")
    public String displaySpotFormSiteStep (Model model){
        
        model.addAttribute(SITE_ATT,new SiteDTO());
        model.addAttribute(REGION_ATT,listRegion);
    
        return Views.SITE_FORM;
    }
    
    @GetMapping("/user/updateSite/{siteID}")
    public String updateSite(@PathVariable String siteID, Model model){
        
        model.addAttribute(SITE_ATT,spotService.searchSiteById(Integer.parseInt(siteID)));
        model.addAttribute(REGION_ATT,listRegion);
        
        return Views.SITE_FORM;
    }
    
    @GetMapping("/user/sectorForm/{siteId}")
    public String displaySpotFormSectorStep(Model model, @PathVariable String siteId) {
        
        model.addAttribute(SECTOR_ATT,new SectorDTO());
        model.addAttribute(SITE_ID_ATT, siteId);
    
        return Views.SECTOR_FORM;
    }
    
    @GetMapping("/user/updateSector/{siteId}/{sectorId}")
    public String updateSector(@PathVariable String siteId, @PathVariable String sectorId, Model model){
        
        model.addAttribute(SECTOR_ATT,spotService.searchSectorById(Integer.parseInt(sectorId)));
        model.addAttribute(SITE_ID_ATT, siteId);
        
        return Views.SECTOR_FORM;
    }
    
    @GetMapping("/user/wayForm/{siteId}/{sectorId}")
    public String displaySpotFormWayStep(Model model, @PathVariable String siteId, @PathVariable String sectorId){
    
        model.addAttribute(WAY_ATT,new WayDTO());
        model.addAttribute(RATING_ATT,listRating);
        model.addAttribute(SITE_ID_ATT,siteId);
        model.addAttribute(SECTOR_ID_ATT,sectorId);
    
        return Views.WAY_FORM;
    }
    
    @GetMapping("/user/updateWay/{sectorId}/{wayId}")
    public String updateWay(@PathVariable String sectorId, @PathVariable String wayId, Model model){
        
        model.addAttribute(WAY_ATT,spotService.searchWayById(Integer.parseInt(wayId)));
        model.addAttribute(RATING_ATT,listRating);
        model.addAttribute(SITE_ID_ATT, sectorId);
        
        return Views.WAY_FORM;
    }
    
    @PostMapping({"/user/saveSite/","/user/saveSite/{siteID}"})
    public String displaySpotAfterSaving(@Valid @ModelAttribute(SITE_ATT) SiteDTO siteDTO,
                                         BindingResult bResult, Model model,
                                         @SessionAttribute(value = "accountSession") AccountSessionDTO accountSessionDTO,
                                         @PathVariable(required = false) String siteID){
        
        if (bResult.hasErrors()) {
            model.addAttribute(SITE_ATT, siteDTO);
            model.addAttribute(REGION_ATT, listRegion);
            model.addAttribute(SPOT_SERV_ATT, spotService);
            return Views.SITE_FORM;
        }
    
        if (siteID != null)
            siteDTO.setId(Integer.parseInt(siteID));
        else
            siteDTO.setIdAccount(accountSessionDTO.getId());
        
        spotService.saveSite(siteDTO);
        
        List<SiteDTO> siteDTOList = spotService.findAllSite();
        model.addAttribute(SEARCH_ATT,new SearchFilter());
        model.addAttribute(RATING_ATT,listRating);
        model.addAttribute(REGION_ATT,listRegion);
        model.addAttribute(LIST_SITE_ATT,siteDTOList);
        
        return Views.SPOT;
    }
    
    @GetMapping("/user/deleteSite/{siteId}")
    public String deleteSite(@PathVariable String siteId, Model model){
        
        spotService.deleteSiteWithId(Integer.parseInt(siteId));
        
        return displaySpotPage(model);
    }
    
    @PostMapping({"/user/saveSector/{siteId}","/user/saveSector/{siteId}/{sectorId}"})
    public String displaySiteAfterSaveSector(@Valid @ModelAttribute(SECTOR_ATT) SectorDTO sectorDTO,
                                             BindingResult bResult, Model model,
                                             @SessionAttribute(value = ACCOUNT_SESSION_ATT) AccountSessionDTO accountSessionDTO,
                                             @PathVariable String siteId, @PathVariable (required = false) String sectorId){
        
        
        if (bResult.hasErrors()) {
            model.addAttribute(SECTOR_ATT, sectorDTO);
            model.addAttribute(SPOT_SERV_ATT, spotService);
            return Views.SECTOR_FORM;
        }
        
        if (sectorId != null)
            sectorDTO.setId(Integer.parseInt(sectorId));
        else
            sectorDTO.setIdAccount(accountSessionDTO.getId());
        
        sectorDTO.setIdSite(Integer.parseInt(siteId));
        spotService.saveSector(sectorDTO);
        
        return displaySite(siteId,model);
    }
    
    @GetMapping("/user/deleteSector/{siteId}/{sectorId}")
    public String deleteSector(@PathVariable String sectorId, Model model, @PathVariable String siteId){
        
        spotService.deleteSectorWithId(Integer.parseInt(sectorId));
        
        return displaySite(siteId, model);
    }
    
    @PostMapping({"/user/saveWay/{siteId}/{sectorId}/","/user/saveWay/{siteId}/{sectorId}/{wayId}"})
    public String displaySiteAfterSaveWay(@Valid @ModelAttribute(WAY_ATT) WayDTO wayDTO,
                                          BindingResult bResult, Model model,
                                          @SessionAttribute(value = ACCOUNT_SESSION_ATT) AccountSessionDTO accountSessionDTO,
                                          @PathVariable String siteId,
                                          @PathVariable String sectorId,
                                          @PathVariable(required = false) String wayId){
        
        if (bResult.hasErrors()) {
            model.addAttribute(WAY_ATT, wayDTO);
            model.addAttribute(RATING_ATT, listRating);
            model.addAttribute(SPOT_SERV_ATT, spotService);
            return Views.WAY_FORM;
        }
        
        if (wayId != null)
            wayDTO.setId(Integer.parseInt(wayId));
        else
            wayDTO.setIdAccount(accountSessionDTO.getId());
        
        wayDTO.setIdSector(Integer.parseInt(sectorId));
        spotService.saveWay(wayDTO);
        
        return displaySite(siteId,model);
    }
    
    @GetMapping("/user/deleteWay/{siteId}/{wayId}")
    public String deleteWay(@PathVariable String wayId, Model model, @PathVariable String siteId){
        
        spotService.deleteWayWithId(Integer.parseInt(wayId));
        
        return displaySite(siteId,model);
    }
    
}
