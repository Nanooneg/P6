package com.nanoo.webapp.controller;

import com.nanoo.business.dto.AccountDTO;
import com.nanoo.business.dto.AccountSessionDTO;
import com.nanoo.business.serviceContract.AccountService;
import com.nanoo.business.util.HandlingEnumValues;
import com.nanoo.webapp.util.SessionHandling;
import com.nanoo.webapp.util.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * @author nanoo
 * @create 11/09/2019 - 17:44
 */
@Controller
@SessionAttributes("accountSession")
public class AccountController {
    
    /* Attributes names */
    private static final String TITLE_ATT = "listTitle";
    private static final String ACCOUNT_SERV_ATT = "registration";
    private static final String ACCOUNT_ATT = "account";
    private static final String ACCOUNT_SESSION_ATT = "accountSession";
    private static final String MESSAGE_ATT = "message";
    private static final String MESSAGE_YES_ATT = "yes";
    private static final String MESSAGE_NO_ATT = "no";
    
    /* Fields names */
    private static final String MAIL_FIELD = "mail";
    
    /* Redirection */
    private static final String LOGIN_REDIRECT = "redirect:/login";
    private static final String USER_AREA_REDIRECT = "redirect:/user/user-area";
    
    /* Message content */
    private static final String ERROR_REGISTER_MESSAGE = "L'enregistrement a échoué !";
    private static final String ERROR_MAIL_MESSAGE = "Cette adresse mail est déjà utilisée";
    private static final String LOGOUT_MESSAGE = "vous nous quittez déjà?";
    private static final String YES_MESSAGE = "Oui, je dois partir";
    private static final String NO_MESSAGE = "Non je reste encore un peu";
    
    private List<String> listTitle = HandlingEnumValues.getEnumTitleStringValues();
    
    private final AccountService accountService;
    
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    
    @GetMapping("/register")
    public String displayAccountRegistrationForm(Model model){
        
        model.addAttribute(ACCOUNT_ATT,new AccountDTO());
        model.addAttribute(TITLE_ATT,listTitle);
        
        return Views.ACCOUNT_FORM;
    }
    
    @GetMapping("/updateAccount/{accountId}")
    public String updateAccount(@PathVariable String accountId, Model model){
        
        AccountDTO accountDTO = accountService.searchAccountById(Integer.parseInt(accountId));
        if (accountDTO.getPostalCode().equals("0"))
            accountDTO.setPostalCode(null);
        
        model.addAttribute(ACCOUNT_ATT, accountDTO);
        model.addAttribute(TITLE_ATT, listTitle);
        
        return Views.ACCOUNT_FORM;
    }
    
    @PostMapping("/updateAccount/{accountId}")
    public String saveUpdatedAccount(@PathVariable("accountId") String accountId,
                                     @Valid @ModelAttribute("account") AccountDTO accountDTO,
                                     BindingResult bResult, Model model){
        
        boolean mailAvailability = accountService.checkMailAvailabilityForUpdate(accountDTO.getMail(), Integer.parseInt(accountId));
        
        if (bResult.hasErrors() || !mailAvailability ) {
            model.addAttribute(ACCOUNT_ATT,accountDTO);
            model.addAttribute(MESSAGE_ATT,ERROR_REGISTER_MESSAGE);
            model.addAttribute(TITLE_ATT,listTitle);
            if (!mailAvailability)
                bResult.addError(new FieldError(ACCOUNT_ATT,MAIL_FIELD,ERROR_MAIL_MESSAGE));
            return Views.ACCOUNT_FORM;
        }
        
        accountDTO.setId(Integer.parseInt(accountId));
        accountService.saveAccount(accountDTO);
        AccountSessionDTO accountSessionDTO = accountService.searchRegisteredAccount(accountDTO);
        
        model.addAttribute(ACCOUNT_SERV_ATT,accountService);
        model.addAttribute(ACCOUNT_SESSION_ATT,accountSessionDTO);
        
        return USER_AREA_REDIRECT;
        
    }
    
    @GetMapping("/login")
    public String displayLoginForm(Model model){
        
        model.addAttribute(ACCOUNT_ATT,new AccountDTO());
        
        return Views.LOGIN;
    }
    
    
    @PostMapping("/saveAccount")
    public String displayLoginFormAfterRegisterAccount(
            @Valid @ModelAttribute("account")AccountDTO accountDTO, BindingResult bResult, Model model){
        
        model.addAttribute(ACCOUNT_ATT,accountDTO);
        boolean mailAvailability = accountService.checkMailAvailability(accountDTO.getMail());
        
        if (bResult.hasErrors() || !mailAvailability) {
            model.addAttribute(MESSAGE_ATT,ERROR_REGISTER_MESSAGE);
            model.addAttribute(TITLE_ATT,listTitle);
            if (!mailAvailability)
                bResult.addError(new FieldError(ACCOUNT_ATT,MAIL_FIELD,ERROR_MAIL_MESSAGE));
            return Views.ACCOUNT_FORM;
        }
        
        accountService.saveAccount(accountDTO);
        model.addAttribute(ACCOUNT_SERV_ATT,accountService);
        
        return Views.LOGIN;
        
    }
    
    @GetMapping("/signout")
    public String confirmLogout(HttpServletResponse response, Model model,
                                @SessionAttribute (value = "accountSession", required = false)AccountSessionDTO accountSessionDTO){
        
        /* if user use previous button after logout */
        SessionHandling.clearCache(response);
        if (accountSessionDTO == null){
            return LOGIN_REDIRECT;
        }
        
        model.addAttribute(MESSAGE_ATT,LOGOUT_MESSAGE);
        model.addAttribute(MESSAGE_YES_ATT,YES_MESSAGE);
        model.addAttribute(MESSAGE_NO_ATT,NO_MESSAGE);
        
        return Views.SIGNOUT;
    }
}

