package com.nanoo.webapp.controller;

import com.nanoo.business.dto.AccountDTO;
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
    private static final String USER_HOME_VIEW = "userHome";
    
    @GetMapping(value = {"/","/home"})
    public String home(Model model, HttpServletRequest request){
    
        HttpSession session = request.getSession();
        
        AccountDTO accountDTO = (AccountDTO) session.getAttribute(ACCOUNT_ATT);
        if (accountDTO != null){
            return USER_HOME_VIEW;
        }
        
        model.addAttribute(MESSAGE_ATT, "Test");
        
        return HOME_VIEW;
    }
    
    @GetMapping("/unlog")
    public String logout(HttpServletRequest request){
    
        HttpSession session = request.getSession();
        session.invalidate();
        
        return HOME_VIEW;
    }
    
}
