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
    
    /* Redirection */
    private static final String LOGIN_REDIRECT = "redirect:/login";
    
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
    public String displaySpotPageWithResult (@ModelAttribute SearchFilter filter, Model model){
        
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
    
    @GetMapping("/spotForm1")
    public String displaySpotFormSiteStep (Model model,
                                           @SessionAttribute(value = "accountSession", required = false) AccountSessionDTO accountSessionDTO){
    
        if (accountSessionDTO == null){
            return LOGIN_REDIRECT;
        }
        
        model.addAttribute(SITE_ATT,new SiteDTO());
        model.addAttribute(REGION_ATT,listRegion);
    
        return Views.SPOT_FORM1;
    }
    
    @GetMapping("/updateSite/{siteID}")
    public String updateSite(@PathVariable String siteID, Model model){
        
        model.addAttribute(SITE_ATT,spotService.searchSiteById(Integer.parseInt(siteID)));
        model.addAttribute(REGION_ATT,listRegion);
        
        return Views.SPOT_FORM1;
    }
    
    @GetMapping("/spotForm2/{siteId}")
    public String displaySpotFormSectorStep(Model model, @PathVariable String siteId,
                                            @SessionAttribute(value = "accountSession", required = false)AccountSessionDTO accountSessionDTO) {
    
        if (accountSessionDTO == null){
            return LOGIN_REDIRECT;
        }
        
        model.addAttribute(SECTOR_ATT,new SectorDTO());
        model.addAttribute(SITE_ID_ATT, siteId);
    
        return Views.SPOT_FORM2;
    }
    
    @GetMapping("/updateSector/{siteId}/{sectorId}")
    public String updateSector(@PathVariable String siteId, @PathVariable String sectorId, Model model){
        
        model.addAttribute(SECTOR_ATT,spotService.searchSectorById(Integer.parseInt(sectorId)));
        model.addAttribute(SITE_ID_ATT, siteId);
        
        return Views.SPOT_FORM2;
    }
    
    @GetMapping("/spotForm3/{sectorId}")
    public String displaySpotFormWayStep(Model model, @PathVariable String sectorId,
                                         @SessionAttribute(value = "accountSession", required = false)AccountSessionDTO accountSessionDTO){
    
        if (accountSessionDTO == null){
            return LOGIN_REDIRECT;
        }
    
        model.addAttribute(WAY_ATT,new WayDTO());
        model.addAttribute(RATING_ATT,listRating);
        model.addAttribute(SECTOR_ID_ATT,sectorId);
    
        return Views.SPOT_FORM3;
    }
    
    @GetMapping("/updateWay/{sectorId}/{wayId}")
    public String updateWay(@PathVariable String sectorId, @PathVariable String wayId, Model model){
        
        model.addAttribute(WAY_ATT,spotService.searchWayById(Integer.parseInt(wayId)));
        model.addAttribute(RATING_ATT,listRating);
        model.addAttribute(SITE_ID_ATT, sectorId);
        
        return Views.SPOT_FORM3;
    }
    
    @PostMapping({"/saveSite/","/saveSite/{siteID}"})
    public String displaySpotAfterSaving(@Valid @ModelAttribute("site") SiteDTO siteDTO,
                                         BindingResult bResult, Model model,
                                         @SessionAttribute(value = "accountSession") AccountSessionDTO accountSessionDTO,
                                         @PathVariable(required = false) String siteID){
        
        if (bResult.hasErrors()) {
            model.addAttribute(SITE_ATT, siteDTO);
            model.addAttribute(REGION_ATT, listRegion);
            model.addAttribute(SPOT_SERV_ATT, spotService);
            return Views.SPOT_FORM1;
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
    
    @GetMapping("/deleteSite/{siteId}")
    public String deleteSite(@PathVariable String siteId, Model model,
                             @SessionAttribute(value = "accountSession", required = false)AccountSessionDTO accountSessionDTO){
        
        spotService.deleteSiteWithId(Integer.parseInt(siteId));
        
        return displaySpotPage(model);
    }
    
    @PostMapping({"/saveSector/{siteId}","/saveSector/{siteId}/{sectorId}"})
    public String displaySiteAfterSaveSector(@Valid @ModelAttribute("sector") SectorDTO sectorDTO,
                                             BindingResult bResult, Model model,
                                             @SessionAttribute(value = "accountSession") AccountSessionDTO accountSessionDTO,
                                             @PathVariable String siteId, @PathVariable (required = false) String sectorId){
        
        
        if (bResult.hasErrors()) {
            model.addAttribute(SECTOR_ATT, sectorDTO);
            model.addAttribute(SPOT_SERV_ATT, spotService);
            return Views.SPOT_FORM2;
        }
        
        if (sectorId != null)
            sectorDTO.setId(Integer.parseInt(sectorId));
        else
            sectorDTO.setIdAccount(accountSessionDTO.getId());
        
        sectorDTO.setIdSite(Integer.parseInt(siteId));
        spotService.saveSector(sectorDTO);
        
        return displaySite(siteId,model);
    }
    
    @GetMapping("/deleteSector/{siteId}/{sectorId}")
    public String deleteSector(@PathVariable String sectorId, Model model, @PathVariable String siteId,
                               @SessionAttribute(value = "accountSession", required = false)AccountSessionDTO accountSessionDTO){
        
        spotService.deleteSectorWithId(Integer.parseInt(sectorId));
        
        return displaySite(siteId, model);
    }
    
    @PostMapping({"/saveWay/{sectorId}","/saveWay/{sectorId}/{wayId}"})
    public String displaySiteAfterSaveWay(@Valid @ModelAttribute("way") WayDTO wayDTO,
                                          BindingResult bResult, Model model,
                                          @SessionAttribute(value = "accountSession") AccountSessionDTO accountSessionDTO,
                                          @PathVariable String sectorId, @PathVariable(required = false) String wayId){
        
        if (bResult.hasErrors()) {
            model.addAttribute(WAY_ATT, wayDTO);
            model.addAttribute(RATING_ATT, listRating);
            model.addAttribute(SPOT_SERV_ATT, spotService);
            return Views.SPOT_FORM3;
        }
        
        if (wayId != null)
            wayDTO.setId(Integer.parseInt(wayId));
        else
            wayDTO.setIdAccount(accountSessionDTO.getId());
        
        wayDTO.setIdSector(Integer.parseInt(sectorId));
        spotService.saveWay(wayDTO);
        
        int siteId = spotService.getSiteIdWithSectorId(sectorId);
        
        return displaySite(Integer.toString(siteId),model);
    }
    
    @GetMapping("/deleteWay/{siteId}/{wayId}")
    public String deleteWay(@PathVariable String wayId, Model model, @PathVariable String siteId,
                            @SessionAttribute(value = "accountSession", required = false)AccountSessionDTO accountSessionDTO){
        
        spotService.deleteWayWithId(Integer.parseInt(wayId));
        
        return displaySite(siteId,model);
    }
    
}
