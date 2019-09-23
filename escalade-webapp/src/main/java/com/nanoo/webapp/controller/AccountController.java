package com.nanoo.webapp.controller;

import com.nanoo.business.dto.AccountDTO;
import com.nanoo.business.serviceContract.AccountService;
import com.nanoo.model.enums.EnumTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
    private static final String MESSAGE_ATT = "message";
    
    private static final String LOGIN_VIEW = "login";
    private static final String REGISTER_VIEW = "register";
    private static final String SIGNOUT_VIEW = "signout";
    
    private List<EnumTitle> listTitle = Arrays.asList(EnumTitle.values());
    
    @Autowired
    private AccountService accountService;
    
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    
    @GetMapping("/register")
    public String displayAccountRegistrationForm(Model model){
        
        model.addAttribute(ACCOUNT_ATT,new AccountDTO());
        model.addAttribute(TITLE_ATT,listTitle);
        
        return REGISTER_VIEW;
    }
    
    @GetMapping("/login")
    public String displayLoginForm(Model model){
        
        model.addAttribute(ACCOUNT_ATT,new AccountDTO());
        
        return LOGIN_VIEW;
    }
    
    
    @PostMapping("/login")
    public String displayLoginFormAfterRegisterAccount(
            @Valid @ModelAttribute("account")AccountDTO accountDTO, BindingResult bResult, Model model){
    
        model.addAttribute(ACCOUNT_ATT,accountDTO);
    
        if (!bResult.hasErrors()) {
            accountService.saveAccount(accountDTO);
            model.addAttribute(ACCOUNT_SERV_ATT,accountService);
            return LOGIN_VIEW;
        }else{
            model.addAttribute(MESSAGE_ATT,"L'enregistrement a échoué!");
            model.addAttribute(TITLE_ATT,listTitle);
            return REGISTER_VIEW;
        }
    }
    
    @GetMapping("/signout")
    public String confirmLogout(HttpServletResponse response, HttpServletRequest request, Model model){
        
        response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
        response.setHeader("Progma","no-cache");
        response.setDateHeader("Expires",0);
    
        HttpSession session = request.getSession();
        if (session.getAttribute(ACCOUNT_ATT) == null || session.getAttribute(ACCOUNT_ATT) == "") {
            model.addAttribute(ACCOUNT_ATT,new AccountDTO());
            return LOGIN_VIEW;
        }
        
        return SIGNOUT_VIEW;
    }
}

