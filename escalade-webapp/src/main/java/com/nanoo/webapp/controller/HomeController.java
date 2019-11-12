package com.nanoo.webapp.controller;

import com.nanoo.business.dto.AccountSessionDTO;
import com.nanoo.webapp.util.Views;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

/**
 * @author nanoo
 * @create 01/09/2019 - 15:03
 */
@Controller
public class HomeController {
    
    /* Attributes names */
    private static final String ACCOUNT_SESSION_ATT = "accountSession";
    
    /* Redirection */
    private static final String USER_HOME_REDIRECT = "redirect:/user/user-area";
    
    @GetMapping(value = {"/","/home"})
    public String home(@SessionAttribute(value = ACCOUNT_SESSION_ATT, required = false) AccountSessionDTO accountSessionDTO){
        
        if (accountSessionDTO != null){
            return USER_HOME_REDIRECT;
        }
        
        return Views.HOME;
    }
    
}
