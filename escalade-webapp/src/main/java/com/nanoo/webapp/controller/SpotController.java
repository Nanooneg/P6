package com.nanoo.webapp.controller;

import com.nanoo.business.dto.AccountDTO;
import com.nanoo.business.dto.SectorDTO;
import com.nanoo.business.dto.SiteDTO;
import com.nanoo.business.dto.WayDTO;
import com.nanoo.business.serviceContract.SpotService;
import com.nanoo.business.util.SearchFilter;
import com.nanoo.model.enums.EnumRating;
import com.nanoo.model.enums.EnumRegion;
import com.nanoo.webapp.util.SessionHandling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * @author nanoo
 * @create 23/09/2019 - 12:08
 */
@Controller
public class SpotController {
    
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
    private static final String SITE_ID_ATT = "siteId";
    private static final String SECTOR_ATT = "sector";
    private static final String WAY_ATT = "way";
    
    private List<EnumRating> listRating = Arrays.asList(EnumRating.values());
    private List<EnumRegion> listRegion = Arrays.asList(EnumRegion.values());
    //private EnumSet<EnumRating> listRating = EnumSet.allOf(EnumRating.a) ;
    
    @Autowired
    private SpotService spotService;
    
    private SessionHandling sessionHandling;
    
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
        
        //TODO
        
        return SPOT_VIEW;
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
    
    @GetMapping("/spotForm3")
    public String displaySpotFormWayStep (HttpServletRequest request, Model model){
    
        /* Check if user has access */
        sessionHandling = new SessionHandling();
        if (sessionHandling.checkSession(request)){
            model.addAttribute(ACCOUNT_ATT,new AccountDTO());
            return LOGIN_VIEW;
        }
    
        model.addAttribute(WAY_ATT,new WayDTO());
    
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
    
    @PostMapping("/saveSector/{siteId}")
    public String displaySpotAfterSaving(@Valid @ModelAttribute("sector") SectorDTO sectorDTO,
                                         BindingResult bResult, Model model, HttpServletRequest request,
                                         @PathVariable String siteId){
        
        if (bResult.hasErrors()) {
            model.addAttribute(SITE_ATT, sectorDTO);
            
            return SPOT_FORM_VIEW1;
        }
        
        // TODO write methos to get accountId
        HttpSession session = request.getSession();
        AccountDTO accountDTO = (AccountDTO) session.getAttribute(ACCOUNT_ATT);
        int accountId = accountDTO.getId();
        
        spotService.saveSector(sectorDTO,siteId,accountId);
        
        List<SiteDTO> siteDTOList = spotService.findAllSite();
        model.addAttribute(SEARCH_ATT,new SearchFilter());
        model.addAttribute(RATING_ATT,listRating);
        model.addAttribute(REGION_ATT,listRegion);
        model.addAttribute(LIST_SITE_ATT,siteDTOList);
        
        return SPOT_VIEW;
    }
    
}
