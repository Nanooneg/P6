package com.nanoo.webapp.controller;

import com.nanoo.business.serviceContract.RegistrationService;
import com.nanoo.model.entities.Account;
import com.nanoo.model.entities.EnumTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * @author nanoo
 * @create 07/09/2019 - 12:01
 */
@Controller
public class AccountController {
    
    private static final String TITLE_ATT = "listTitle";
    private static final String REGISTRATION_ATT = "registration";
    private static final String ACCOUNT_ATT = "account";
    
    private static final String LOGIN_VIEW = "login";
    private static final String REGISTER_VIEW = "register";
    private static final String REGISTERED_HOME_VIEW = "home";
    
    List<EnumTitle> listTitle = Arrays.asList(EnumTitle.values());
    
    @Autowired
    private RegistrationService registrationService;

    @RequestMapping("/login")
    public ModelAndView displayLoginForm(){
        return new ModelAndView(LOGIN_VIEW);
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView displayLoginFormAfterRegisterAccount(HttpServletRequest req){
        Account account = registrationService.saveAccount(req);
        
        if (!registrationService.getErrors().isEmpty()) {
            ModelAndView mav = new ModelAndView(REGISTER_VIEW);
            mav.addObject(TITLE_ATT,listTitle);
            mav.addObject(REGISTRATION_ATT,registrationService);
            mav.addObject(ACCOUNT_ATT,account);
            return mav;
        }else {
            ModelAndView mav = new ModelAndView(LOGIN_VIEW);
            mav.addObject(REGISTRATION_ATT,registrationService);
            mav.addObject(ACCOUNT_ATT,account);
            return mav;
        }
    }

    @RequestMapping("/register")
    public ModelAndView displayAccountRegistrationForm(){
        
        ModelAndView mav = new ModelAndView(REGISTER_VIEW);
        mav.addObject(TITLE_ATT,listTitle);
        
        return mav;
    }
    
    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public ModelAndView homePageAfterLoginRequest(HttpServletRequest req) {
        Account account = registrationService.searchRegisteredAccount(req);
        
        if (account != null) {
            ModelAndView mav = new ModelAndView(REGISTERED_HOME_VIEW);
            mav.addObject(ACCOUNT_ATT,account);
            return mav;
        }else {
            ModelAndView mav = new ModelAndView(LOGIN_VIEW);
            mav.addObject(REGISTRATION_ATT,registrationService);
            return mav;
        }
    }
    
}
