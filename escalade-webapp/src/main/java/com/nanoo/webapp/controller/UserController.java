package com.nanoo.webapp.controller;

import com.nanoo.business.serviceContract.AccountService;
import com.nanoo.business.dto.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author nanoo
 * @create 16/09/2019 - 23:22
 */
@Controller
@RequestMapping("/user")
public class UserController {
    
    private static final String ACCOUNT_SERV_ATT = "registration";
    private static final String ACCOUNT_ATT = "account";
    
    private static final String LOGIN_VIEW = "login";
    private static final String USER_HOME_VIEW = "user";
    
    @Autowired
    private AccountService accountService;
    
    @PostMapping("/user-area")
    public String homePageAfterLoginRequest(
            @ModelAttribute("account") AccountDTO accountDTO, Model model, HttpServletRequest request) {
        
        accountDTO = accountService.searchRegisteredAccount(accountDTO);
        
        if (accountService.getErrors().isEmpty()) {
            HttpSession session = request.getSession();
            session.setAttribute(ACCOUNT_ATT,accountDTO);
            return USER_HOME_VIEW;
        }else{
            model.addAttribute(ACCOUNT_ATT,accountDTO);
            model.addAttribute(ACCOUNT_SERV_ATT,accountService);
            return LOGIN_VIEW;
        }
    }
    
    @GetMapping("/user-area")
    public String homePageAfterLogoutRequest(){
        return USER_HOME_VIEW;
    }
}
