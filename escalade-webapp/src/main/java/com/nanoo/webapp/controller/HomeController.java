package com.nanoo.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author nanoo
 * @create 01/09/2019 - 15:03
 */
@Controller
public class HomeController {
    
    private static final String MESSAGE_ATT = "message";
    
    private static final String HOME_VIEW = "home";
    
    @GetMapping(value = {"/","/home"})
    public String home(Model model){
        
        model.addAttribute(MESSAGE_ATT, "Test");
        
        return HOME_VIEW;
    }
    
    
    
}
