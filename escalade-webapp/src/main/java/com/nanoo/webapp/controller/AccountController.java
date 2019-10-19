package com.nanoo.webapp.controller;

import com.nanoo.business.dto.AccountDTO;
import com.nanoo.business.serviceContract.AccountService;
import com.nanoo.business.util.HandlingEnumValues;
import com.nanoo.webapp.util.SessionHandling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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
    private static final String MESSAGE_YES_ATT = "yes";
    private static final String MESSAGE_NO_ATT = "no";
    
    private static final String MAIL_FIELD = "mail";
    
    private static final String LOGIN_VIEW = "login";
    private static final String REGISTER_VIEW = "register";
    private static final String UPDATE_VIEW = "updateAccount";
    private static final String SIGNOUT_VIEW = "signout";
    
    private static final String ERROR_REGISTER_MESSAGE = "L'enregistrement a échoué !";
    private static final String ERROR_MAIL_MESSAGE = "Cette adresse mail est déjà utilisée";
    private static final String LOGOUT1_MESSAGE = "vous nous quittez déjà?";
    private static final String LOGOUT2_MESSAGE = "vous devez vous déconnecter pour faire ceci !";
    private static final String YES1_MESSAGE = "Oui, je dois partir";
    private static final String YES2_MESSAGE = "Ok, je me déconnecte";
    private static final String NO_MESSAGE = "Non je reste encore un peu";
    
    private HandlingEnumValues enumValues = new HandlingEnumValues();
    private List<String> listTitle = enumValues.getEnumTitleStringValues();
    SessionHandling sessionHandling;
    
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
    public String displayAccountRegistrationForm(HttpServletRequest request, Model model){
    
        /* Check if user has access */
        sessionHandling = new SessionHandling();
        if (!sessionHandling.checkSession(request)){
            model.addAttribute(MESSAGE_ATT,LOGOUT2_MESSAGE);
            model.addAttribute(MESSAGE_YES_ATT,YES2_MESSAGE);
            model.addAttribute(MESSAGE_NO_ATT,NO_MESSAGE);
            return SIGNOUT_VIEW;
        }
        
        model.addAttribute(ACCOUNT_ATT,new AccountDTO());
        model.addAttribute(TITLE_ATT,listTitle);
        
        return REGISTER_VIEW;
    }
    
    @GetMapping("/updateAccount/{accountId}")
    public String updateAccount(@PathVariable String accountId, Model model){
        AccountDTO accountDTO = accountService.searchAccountById(Integer.parseInt(accountId));
        if (accountDTO.getPostalCode().equals("0"))
            accountDTO.setPostalCode(null);
        
        model.addAttribute(ACCOUNT_ATT, accountDTO);
        model.addAttribute(TITLE_ATT, listTitle);
        
        return UPDATE_VIEW;
    }
    
    @PostMapping("/updateAccount/{accountId}")
    public String saveUpdatedAccount(@PathVariable("accountId") String accountId,
                                     @Valid @ModelAttribute("account") AccountDTO accountDTO,
                                     BindingResult bResult, Model model, HttpServletRequest request){
    
        sessionHandling = new SessionHandling();
        boolean mailAvailability = accountService.checkMailAvailabilityForUpdate(accountDTO.getMail(), Integer.parseInt(accountId));
        
        if (bResult.hasErrors() || !mailAvailability ) {
            model.addAttribute(ACCOUNT_ATT,accountDTO);
            model.addAttribute(MESSAGE_ATT,ERROR_REGISTER_MESSAGE);
            model.addAttribute(TITLE_ATT,listTitle);
            if (!mailAvailability)
                bResult.addError(new FieldError(ACCOUNT_ATT,MAIL_FIELD,ERROR_MAIL_MESSAGE));
            return UPDATE_VIEW;
        }
    
        accountDTO.setId(Integer.parseInt(accountId));
        accountService.saveAccount(accountDTO);
        
        model.addAttribute(ACCOUNT_SERV_ATT,accountService);
        sessionHandling.setSessionAttribute(request,accountDTO);
    
        return "redirect:/user/user-area";
        
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
        boolean mailAvailability = accountService.checkMailAvailability(accountDTO.getMail());
        
        if (bResult.hasErrors() || !mailAvailability) {
            model.addAttribute(MESSAGE_ATT,ERROR_REGISTER_MESSAGE);
            model.addAttribute(TITLE_ATT,listTitle);
            if (!mailAvailability)
                bResult.addError(new FieldError(ACCOUNT_ATT,MAIL_FIELD,ERROR_MAIL_MESSAGE));
            return REGISTER_VIEW;
        }
        
        accountService.saveAccount(accountDTO);
        model.addAttribute(ACCOUNT_SERV_ATT,accountService);
        
        return LOGIN_VIEW;
        
    }
    
    @GetMapping("/signout")
    public String confirmLogout(HttpServletResponse response, HttpServletRequest request, Model model){
        sessionHandling = new SessionHandling();
    
        sessionHandling.clearCache(response);
    
        /* Check if user has access */
        if (sessionHandling.checkSession(request)){
            model.addAttribute(ACCOUNT_ATT,new AccountDTO());
            return LOGIN_VIEW;
        }
        
        model.addAttribute(MESSAGE_ATT,LOGOUT1_MESSAGE);
        model.addAttribute(MESSAGE_YES_ATT,YES1_MESSAGE);
        model.addAttribute(MESSAGE_NO_ATT,NO_MESSAGE);
        
        return SIGNOUT_VIEW;
    }
}

