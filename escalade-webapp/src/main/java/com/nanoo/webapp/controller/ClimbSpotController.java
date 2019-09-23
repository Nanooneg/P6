package com.nanoo.webapp.controller;

import com.nanoo.business.dto.AccountDTO;
import com.nanoo.business.search.SearchFilter;
import com.nanoo.business.serviceContract.AccountService;
import com.nanoo.model.entities.Sector;
import com.nanoo.model.entities.Site;
import com.nanoo.model.entities.Way;
import com.nanoo.model.enums.EnumRating;
import com.nanoo.model.enums.EnumRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * @author nanoo
 * @create 23/09/2019 - 12:08
 */
@Controller
public class ClimbSpotController {
    
    private static final String SPOT_VIEW = "climbSpot";
    private static final String SPOT_FORM_VIEW = "spotForm";
    private static final String LOGIN_VIEW = "login";
    
    private static final String ACCOUNT_ATT = "account";
    private static final String RATING_ATT = "listRating";
    private static final String REGION_ATT = "listRegion";
    private static final String SEARCH_ATT = "searchAttribut";
    private static final String SITE_ATT = "site";
    private static final String SECTOR_ATT = "sector";
    private static final String WAY_ATT = "way";
    
    private List<EnumRating> listRating = Arrays.asList(EnumRating.values());
    private List<EnumRegion> listRegion = Arrays.asList(EnumRegion.values());
    //private EnumSet<EnumRating> listRating = EnumSet.allOf(EnumRating.a) ;
    
    @Autowired
    private AccountService accountService;
    
    @GetMapping("/climbSpot")
    public String displaySpotPage (Model model){
        
        model.addAttribute(SEARCH_ATT,new SearchFilter());
        model.addAttribute(RATING_ATT,listRating);
        model.addAttribute(REGION_ATT,listRegion);
        
        return SPOT_VIEW;
    }
    
    @PostMapping("/climbSpot")
    public String displaySpotPageWithResult (@ModelAttribute SearchFilter filter, Model model){
        
        
        
        return SPOT_VIEW;
    }
    
    @GetMapping("/spotForm")
    public String displaySpotForm (HttpServletRequest request, Model model){
    
        HttpSession session = request.getSession();
        if (session.getAttribute(ACCOUNT_ATT) == null || session.getAttribute(ACCOUNT_ATT) == "") {
            model.addAttribute(ACCOUNT_ATT,new AccountDTO());
            return LOGIN_VIEW;
        }
        
        model.addAttribute(SITE_ATT,new Site());
        model.addAttribute(SECTOR_ATT,new Sector());
        model.addAttribute(WAY_ATT,new Way());
    
        return SPOT_FORM_VIEW;
    }
    
}
