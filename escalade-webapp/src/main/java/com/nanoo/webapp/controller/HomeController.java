package com.nanoo.webapp.controller;

import com.nanoo.webapp.util.SessionHandling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author nanoo
 * @create 01/09/2019 - 15:03
 */
@Controller
public class HomeController {
    
    private static final String HOME_VIEW = "home";
    
    SessionHandling sessionHandling;
    
    
    @GetMapping(value = {"/","/home"})
    public String home(HttpServletRequest request){
        
        /* Check if user has session */
        sessionHandling = new SessionHandling();
        if (!sessionHandling.checkSession(request)){
            return "redirect:/user/user-area" ;
        }
        
        return HOME_VIEW;
    }
    
    @GetMapping("/unlog")
    public String logout(HttpServletRequest request){
        
        sessionHandling = new SessionHandling();
        sessionHandling.finishSession(request);
        
        return home(request);
    }
    
}
