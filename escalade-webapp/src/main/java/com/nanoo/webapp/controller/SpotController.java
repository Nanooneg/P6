package com.nanoo.webapp.controller;

import com.nanoo.business.dto.AccountDTO;
import com.nanoo.business.dto.SectorDTO;
import com.nanoo.business.dto.SiteDTO;
import com.nanoo.business.dto.WayDTO;
import com.nanoo.business.serviceContract.AccountService;
import com.nanoo.business.serviceContract.SpotService;
import com.nanoo.business.util.HandlingEnumValues;
import com.nanoo.business.util.SearchFilter;
import com.nanoo.webapp.util.SessionHandling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author nanoo
 * @create 23/09/2019 - 12:08
 */
@Controller
public class SpotController {
    
    private static final String SITE_VIEW = "site";
    private static final String SPOT_VIEW = "climbSpot";
    private static final String SPOT_FORM_VIEW1 = "spotForm1";
    private static final String SPOT_FORM_VIEW2 = "spotForm2";
    private static final String SPOT_FORM_VIEW3 = "spotForm3";
    private static final String LOGIN_VIEW = "login";
    
    private static final String ACCOUNT_ATT = "account";
    private static final String LIST_SITE_ATT = "listSite";
    private static final String RATING_ATT = "listRating";
    private static final String REGION_ATT = "listRegion";
    private static final String SEARCH_ATT = "searchAttribut";
    private static final String SITE_ATT = "site";
    private static final String RESULT_SITE_SEARCH_ATT = "listSiteSearchResult";
    private static final String SECTOR_ATT = "sector";
    private static final String SITE_ID_ATT = "siteId";
    private static final String SECTOR_ID_ATT = "sectorId";
    private static final String LIST_SECTOR_ATT = "listSector";
    private static final String WAY_ATT = "way";
    private static final String MAP_WAY_BY_SECTOR_ID_ATT = "wayListBySectorId";
    
    private HandlingEnumValues enumValues = new HandlingEnumValues();
    private List<String> listRating = enumValues.getEnumRatingStringValues();
    private List<String> listRegion = enumValues.getEnumRegionStringValues();
    
    @Autowired private SpotService spotService;
    @Autowired private AccountService accountService;
    
    private SessionHandling sessionHandling;
    
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    
    @GetMapping("/climbSpot")
    public String displaySpotPage (Model model){
        
        List<SiteDTO> siteDTOList = spotService.findAllSite();
        
        model.addAttribute(SEARCH_ATT,new SearchFilter());
        model.addAttribute(RATING_ATT,listRating);
        model.addAttribute(REGION_ATT,listRegion);
        model.addAttribute(LIST_SITE_ATT,siteDTOList);
        
        return SPOT_VIEW;
    }
    
    @PostMapping("/climbSpot")
    public String displaySpotPageWithResult (@ModelAttribute SearchFilter filter, Model model){
        
        List<SiteDTO> siteDTOListResult = spotService.searchSiteByFilter(filter);
        model.addAttribute(LIST_SITE_ATT,siteDTOListResult);
        model.addAttribute(SEARCH_ATT, filter);
        model.addAttribute(RATING_ATT,listRating);
        model.addAttribute(REGION_ATT,listRegion);
        
        return SPOT_VIEW;
    }
    
    @GetMapping("/site/{siteId}")
    public String displaySite (@PathVariable String siteId, Model model){
    
        SiteDTO siteDTO = spotService.searchSiteById(Integer.parseInt(siteId));
        AccountDTO accountDTO = accountService.searchAccountLightById(siteDTO.getIdAccount());
        List<SectorDTO> sectorDTOList = spotService.searchSectorBySiteId(Integer.parseInt(siteId));
        Map<Integer,List<WayDTO>> wayDTOList = spotService.searchWayBySectorId(sectorDTOList);
        System.out.println(wayDTOList);
        model.addAttribute(SITE_ATT, siteDTO);
        model.addAttribute(ACCOUNT_ATT,accountDTO);
        model.addAttribute(LIST_SECTOR_ATT,sectorDTOList);
        model.addAttribute(MAP_WAY_BY_SECTOR_ID_ATT,wayDTOList);
        
        return SITE_VIEW;
    }
    
    @GetMapping("/changeLabel/{siteId}")
    public String changeLabel(@PathVariable String siteId, Model model){
        
        spotService.changeLabel(Integer.parseInt(siteId));
        
        return displaySite(siteId,model);
    }
    
    @GetMapping("/spotForm1")
    public String displaySpotFormSiteStep (HttpServletRequest request, Model model){
    
        /* Check if user has access */
        sessionHandling = new SessionHandling();
        if (sessionHandling.checkSession(request)){
            model.addAttribute(ACCOUNT_ATT,new AccountDTO());
            return LOGIN_VIEW;
        }
        
        model.addAttribute(SITE_ATT,new SiteDTO());
        model.addAttribute(REGION_ATT,listRegion);
    
        return SPOT_FORM_VIEW1;
    }
    
    @GetMapping("/spotForm2/{siteId}")
    public String displaySpotFormSectorStep(HttpServletRequest request, Model model, @PathVariable String siteId){
    
        //TODO get back the siteId
        
        /* Check if user has access */
        sessionHandling = new SessionHandling();
        if (sessionHandling.checkSession(request)){
            model.addAttribute(ACCOUNT_ATT,new AccountDTO());
            return LOGIN_VIEW;
        }
        
        model.addAttribute(SECTOR_ATT,new SectorDTO());
        model.addAttribute(SITE_ID_ATT, siteId);
    
        return SPOT_FORM_VIEW2;
    }
    
    @GetMapping("/spotForm3/{sectorId}")
    public String displaySpotFormWayStep(HttpServletRequest request, Model model, @PathVariable String sectorId){
    
        /* Check if user has access */
        sessionHandling = new SessionHandling();
        if (sessionHandling.checkSession(request)){
            model.addAttribute(ACCOUNT_ATT,new AccountDTO());
            return LOGIN_VIEW;
        }
    
        model.addAttribute(WAY_ATT,new WayDTO());
        model.addAttribute(RATING_ATT,listRating);
        model.addAttribute(SECTOR_ID_ATT,sectorId);
    
        return SPOT_FORM_VIEW3;
    }
    
    @PostMapping("/saveSite")
    public String displaySpotAfterSaving (@Valid @ModelAttribute ("site")SiteDTO siteDTO,
                                          BindingResult bResult, Model model, HttpServletRequest request){
    
        if (bResult.hasErrors()) {
            model.addAttribute(SITE_ATT, siteDTO);
            model.addAttribute(REGION_ATT,listRegion);
    
            return SPOT_FORM_VIEW1;
        }
        
        HttpSession session = request.getSession();
        AccountDTO accountDTO = (AccountDTO) session.getAttribute(ACCOUNT_ATT);
        int accountId = accountDTO.getId();
    
        spotService.saveSite(siteDTO,accountId);
    
        List<SiteDTO> siteDTOList = spotService.findAllSite();
        model.addAttribute(SEARCH_ATT,new SearchFilter());
        model.addAttribute(RATING_ATT,listRating);
        model.addAttribute(REGION_ATT,listRegion);
        model.addAttribute(LIST_SITE_ATT,siteDTOList);
        
        return SPOT_VIEW;
    }
    
    @GetMapping("/deleteSite/{siteId}")
    public String deleteSite(@PathVariable String siteId, Model model, HttpServletRequest request){
    
        /* Check if user has access TODO change system to give acces to member and admin only*/
        sessionHandling = new SessionHandling();
        if (sessionHandling.checkSession(request)){
            model.addAttribute(ACCOUNT_ATT,new AccountDTO());
            return LOGIN_VIEW;
        }
        
        spotService.deleteSiteWithId(Integer.parseInt(siteId));
        
        return displaySpotPage(model);
    }
    
    @PostMapping("/saveSector/{siteId}")
    public String displaySpotAfterSaving(@Valid @ModelAttribute("sector") SectorDTO sectorDTO,
                                         BindingResult bResult, Model model, HttpServletRequest request,
                                         @PathVariable String siteId){
        
        if (bResult.hasErrors()) {
            model.addAttribute(SECTOR_ATT, sectorDTO);
            
            return SPOT_FORM_VIEW2;
        }
        
        // TODO write methos to get accountId
        HttpSession session = request.getSession();
        AccountDTO accountDTO = (AccountDTO) session.getAttribute(ACCOUNT_ATT);
        int accountId = accountDTO.getId();
        
        spotService.saveSector(sectorDTO,siteId,accountId);
        
        return displaySite(siteId,model);
    }
    
    @GetMapping("/deleteSector/{siteId}/{sectorId}")
    public String deleteSector(@PathVariable String sectorId, Model model, HttpServletRequest request, @PathVariable String siteId){
        
        /* Check if user has access TODO change system to give acces to member and admin only*/
        sessionHandling = new SessionHandling();
        if (sessionHandling.checkSession(request)){
            model.addAttribute(ACCOUNT_ATT,new AccountDTO());
            return LOGIN_VIEW;
        }
        
        spotService.deleteSectorWithId(Integer.parseInt(sectorId));
        
        return displaySite(siteId, model);
    }
    
    @PostMapping("/saveWay/{sectorId}")
    public String displaySiteAfterSaveWay(@Valid@ModelAttribute("way") WayDTO wayDTO,
                                          BindingResult bResult,Model model,HttpServletRequest request,
                                          @PathVariable String sectorId){
    
        if (bResult.hasErrors()) {
            model.addAttribute(WAY_ATT, wayDTO);
        
            return SPOT_FORM_VIEW3;
        }
    
        // TODO write methos to get accountId
        HttpSession session = request.getSession();
        AccountDTO accountDTO = (AccountDTO) session.getAttribute(ACCOUNT_ATT);
        int accountId = accountDTO.getId();
        
        int siteId = spotService.getSiteIdWithSectorId(sectorId);
        
        spotService.saveWay(wayDTO,sectorId,accountId);
        
        return displaySite(Integer.toString(siteId),model);
    }
    
    @GetMapping("/deleteWay/{siteId}/{wayId}")
    public String deleteWay(@PathVariable String wayId, Model model, HttpServletRequest request, @PathVariable String siteId){
        
        /* Check if user has access TODO change system to give acces to member and admin only*/
        sessionHandling = new SessionHandling();
        if (sessionHandling.checkSession(request)){
            model.addAttribute(ACCOUNT_ATT,new AccountDTO());
            return LOGIN_VIEW;
        }
        
        spotService.deleteWayWithId(Integer.parseInt(wayId));
        
        return displaySite(siteId,model);
    }
    
}
