package com.nanoo.webapp.controller;

import com.nanoo.business.serviceContract.AccountService;
import com.nanoo.model.DTO.AccountDTO;
import com.nanoo.model.entities.Account;
import com.nanoo.model.enums.EnumTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * @author nanoo
 * @create 11/09/2019 - 17:44
 */
@Controller
public class AccountController {
    
    private static final String TITLE_ATT = "listTitle";
    private static final String ACCOUNT_SERV_ATT = "registration";
    private static final String ACCOUNT_ATT = "account";
    
    private static final String LOGIN_VIEW = "login";
    private static final String REGISTER_VIEW = "register";
    private static final String REGISTERED_HOME_VIEW = "home"; //TODO
    
    private List<EnumTitle> listTitle = Arrays.asList(EnumTitle.values());
    
    @Autowired
    private AccountService accountService;
    
    @GetMapping("/login")
    public ModelAndView displayLoginForm(){
        return new ModelAndView(LOGIN_VIEW);
    }
    
    @PostMapping("/login")
    public String displayLoginFormAfterRegisterAccount(
            @ModelAttribute("account")AccountDTO accountDTO, Model model){
        
        accountDTO = accountService.saveAccountTestMVC(accountDTO);
    
        model.addAttribute(ACCOUNT_ATT,accountDTO);
        model.addAttribute(ACCOUNT_SERV_ATT,accountService);
        
        if (accountService.getErrors().isEmpty()) {
            return LOGIN_VIEW;
        }else {
            model.addAttribute(TITLE_ATT,listTitle);
            return REGISTER_VIEW;
        }
    }
    
    @GetMapping("/register")
    public String displayAccountRegistrationForm(Model model){
        
        model.addAttribute(ACCOUNT_ATT,new Account());
        model.addAttribute(TITLE_ATT,listTitle);
        
        return REGISTER_VIEW;
    }
    
    @PostMapping(value = "/home")
    public String homePageAfterLoginRequest(
            @ModelAttribute ("account") AccountDTO accountDTO, Model model) {
    
        accountDTO = accountService.searchRegisteredAccount(accountDTO);
    
        model.addAttribute(ACCOUNT_ATT,accountDTO);
        model.addAttribute(ACCOUNT_SERV_ATT,accountService);
        
        if (accountService.getErrors().isEmpty()) {
            return REGISTERED_HOME_VIEW;
        }else {
            return LOGIN_VIEW;
        }
    }
    
}

