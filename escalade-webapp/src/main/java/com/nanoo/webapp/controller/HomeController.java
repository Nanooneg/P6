package com.nanoo.webapp.controller;

import com.nanoo.business.serviceContract.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author nanoo
 * @create 01/09/2019 - 15:03
 */
@Controller
public class HomeController {
    
    @Autowired
    private RegistrationService registrationService;
    
    @RequestMapping("/")
    public ModelAndView home(){
        
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("message", "Page de bienvenue");
        
        return mav;
    }
    
    
    
}
