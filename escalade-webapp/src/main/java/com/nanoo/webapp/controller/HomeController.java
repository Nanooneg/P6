package com.nanoo.webapp.controller;

import com.nanoo.webapp.util.SessionHandling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author nanoo
 * @create 01/09/2019 - 15:03
 */
@Controller
public class HomeController {
    
    private static final String HOME_VIEW = "home";
    
    
    @GetMapping(value = {"/","/home"})
    public String home(HttpServletRequest request){
        
        /* Check if user has session */
        SessionHandling sessionHandling = new SessionHandling();
        if (!sessionHandling.checkSession(request)){
            return "redirect:/user/user-area" ;
        }
        
        return HOME_VIEW;
    }
    
    @GetMapping("/unlog")
    public String logout(HttpServletRequest request){
        
        HttpSession session = request.getSession();
        session.invalidate();
        
        return home(request);
    }
    
}
