package com.nanoo.webapp.controller;

import com.nanoo.business.dto.AccountSessionDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

/**
 * @author nanoo
 * @create 01/09/2019 - 15:03
 */
@Controller
public class HomeController {
    
    private static final String HOME_VIEW = "home";
    
    
    @GetMapping(value = {"/","/home"})
    public String home(@SessionAttribute(value = "accountSession", required = false) AccountSessionDTO accountSessionDTO){
        
        if (accountSessionDTO != null){
            return "redirect:/user/user-area" ;
        }
        
        return HOME_VIEW;
    }
    
}
