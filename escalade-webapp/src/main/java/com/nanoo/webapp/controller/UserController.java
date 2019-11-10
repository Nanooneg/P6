package com.nanoo.webapp.controller;

import com.nanoo.business.dto.*;
import com.nanoo.business.serviceContract.AccountService;
import com.nanoo.business.serviceContract.SpotService;
import com.nanoo.business.serviceContract.TopoBookingService;
import com.nanoo.business.serviceContract.TopoService;
import com.nanoo.webapp.util.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

/**
 * @author nanoo
 * @create 16/09/2019 - 23:22
 */
@Controller
@RequestMapping("/user")
@SessionAttributes("accountSession")
public class UserController {
    
    /* Attributes names */
    private static final String ACCOUNT_SERV_ATT = "registration";
    private static final String ACCOUNT_ATT = "account";
    private static final String ACCOUNT_SESSION_ATT = "accountSession";
    private static final String LIST_SITE_ATT = "listSite";
    private static final String LIST_TOPO_ATT = "listTopo";
    private static final String TOPOBOOKING_R_ATT = "topoBookingReceived";
    private static final String TOPOBOOKING_S_ATT = "topoBookingSent";
    
    private final AccountService accountService;
    private final SpotService spotService;
    private final TopoService topoService;
    private final TopoBookingService topoBookingService;
    
    @Autowired
    public UserController(AccountService accountService, SpotService spotService, TopoService topoService, TopoBookingService topoBookingService) {
        this.accountService = accountService;
        this.spotService = spotService;
        this.topoService = topoService;
        this.topoBookingService = topoBookingService;
    }
    
    @PostMapping("/user-area")
    public String loginValidation(@ModelAttribute("account") AccountDTO accountDTO, Model model) {
        
        AccountSessionDTO accountSessionDTO = accountService.searchRegisteredAccount(accountDTO);
        
        if (accountService.getErrors().isEmpty()) {
            model.addAttribute(ACCOUNT_SESSION_ATT,accountSessionDTO);
            return getUserHomeView(accountSessionDTO, model);
        }else{
            model.addAttribute(ACCOUNT_ATT,accountDTO);
            model.addAttribute(ACCOUNT_SERV_ATT,accountService);
            return Views.LOGIN;
        }
    }
    
    @GetMapping("/user-area")
    public String getUserHomeView(@SessionAttribute("accountSession") AccountSessionDTO accountSessionDTO, Model model){
        
        List<TopoDTO> topoDTOList = topoService.searchTopoByAccountId(accountSessionDTO.getId());
        List<SiteDTO> siteDTOList = spotService.searchSiteByAccountId(accountSessionDTO.getId());
        List<TopoBookingDTO> topoBookingReceivedPendingStatusDTOList =
                topoBookingService.searchAllTopoBookingByIdOwnerWithPendingStatus(accountSessionDTO.getId());
        List<TopoBookingDTO> topoBookingSentDTOList =
                topoBookingService.searchAllTopoBookingByIdBorrower(accountSessionDTO.getId());
        
        model.addAttribute(LIST_TOPO_ATT, topoDTOList);
        model.addAttribute(LIST_SITE_ATT, siteDTOList);
        model.addAttribute(TOPOBOOKING_R_ATT, topoBookingReceivedPendingStatusDTOList.size());
        model.addAttribute(TOPOBOOKING_S_ATT, topoBookingSentDTOList.size());
        
        return Views.USER_HOME;
    }
    
    @GetMapping("/unlog")
    public String logout(SessionStatus status){
        
        status.setComplete();
        
        return Views.HOME;
    }
}
