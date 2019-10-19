package com.nanoo.webapp.controller;

import com.nanoo.business.dto.AccountDTO;
import com.nanoo.business.dto.SiteDTO;
import com.nanoo.business.dto.TopoBookingDTO;
import com.nanoo.business.dto.TopoDTO;
import com.nanoo.business.serviceContract.AccountService;
import com.nanoo.business.serviceContract.SpotService;
import com.nanoo.business.serviceContract.TopoService;
import com.nanoo.webapp.util.SessionHandling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author nanoo
 * @create 16/09/2019 - 23:22
 */
@Controller
@RequestMapping("/user")
public class UserController {
    
    private static final String ACCOUNT_SERV_ATT = "registration";
    private static final String ACCOUNT_ATT = "account";
    private static final String LIST_SITE_ATT = "listSite";
    private static final String LIST_TOPO_ATT = "listTopo";
    private static final String TOPOBOOKING_R_ATT = "topoBookingReceived";
    private static final String TOPOBOOKING_S_ATT = "topoBookingSent";
    
    private static final String LOGIN_VIEW = "login";
    private static final String USER_HOME_VIEW = "user";
    
    private SessionHandling sessionHandling;
    
    private final AccountService accountService;
    private final SpotService spotService;
    private final TopoService topoService;
    
    @Autowired
    public UserController(AccountService accountService, SpotService spotService, TopoService topoService) {
        this.accountService = accountService;
        this.spotService = spotService;
        this.topoService = topoService;
    }
    
    @PostMapping("/user-area")
    public String loginValidation(@ModelAttribute("account") AccountDTO accountDTO,
                                  Model model, HttpServletRequest request) {
        
        sessionHandling = new SessionHandling();
        accountDTO = accountService.searchRegisteredAccount(accountDTO);
        
        if (accountService.getErrors().isEmpty()) {
            sessionHandling.setSessionAttribute(request, accountDTO);
            return getUserHomeView(request, model);
        }else{
            model.addAttribute(ACCOUNT_ATT,accountDTO);
            model.addAttribute(ACCOUNT_SERV_ATT,accountService);
            return LOGIN_VIEW;
        }
    }
    
    @GetMapping("/user-area")
    public String getUserHomeView(HttpServletRequest request, Model model){
    
        sessionHandling = new SessionHandling();
        AccountDTO accountDTOLight = sessionHandling.getSessionAttribute(request);
    
        List<TopoDTO> topoDTOList = topoService.searchTopoByAccountId(accountDTOLight.getId());
        List<SiteDTO> siteDTOList = spotService.searchSiteByAccountId(accountDTOLight.getId());
        List<TopoBookingDTO> topoBookingReceivedDTOList = topoService.searchAllTopoBookingByTopoAccountIdWithPendingStatus(accountDTOLight.getId());
        List<TopoBookingDTO> topoBookingSentDTOList = topoService.searchAllTopoBookingByAccountId(accountDTOLight.getId());
        
        model.addAttribute(LIST_TOPO_ATT, topoDTOList);
        model.addAttribute(LIST_SITE_ATT, siteDTOList);
        model.addAttribute(TOPOBOOKING_R_ATT, topoBookingReceivedDTOList.size());
        model.addAttribute(TOPOBOOKING_S_ATT, topoBookingSentDTOList.size());
        
        return USER_HOME_VIEW;
    }
}
