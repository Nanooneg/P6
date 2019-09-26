package com.nanoo.webapp.controller;

import com.nanoo.webapp.util.SessionHandling;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author nanoo
 * @create 01/09/2019 - 15:03
 */
@Controller
public class HomeController {
    
    private static final String MESSAGE_ATT = "message";
    private static final String ACCOUNT_ATT = "account";
    
    private static final String HOME_VIEW = "home";
    private static final String USER_HOME_VIEW = "user";
    
    @GetMapping(value = {"/","/home"})
    public String home(Model model, HttpServletRequest request){
        
        /* Check if user has session */
        SessionHandling sessionHandling = new SessionHandling();
        if (!sessionHandling.checkSession(request)){
            return USER_HOME_VIEW;
        }
        
        return HOME_VIEW;
    }
    
    @GetMapping("/unlog")
    public String logout(HttpServletRequest request){
        
        HttpSession session = request.getSession();
        session.invalidate();
        
        return HOME_VIEW;
    }
    
}
