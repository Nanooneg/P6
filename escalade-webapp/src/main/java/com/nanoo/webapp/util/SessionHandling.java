package com.nanoo.webapp.util;

import com.nanoo.business.dto.AccountDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author nanoo
 * @create 24/09/2019 - 10:46
 */
public class SessionHandling {
    
    //TODO make a filter to limit acces with url ??
    
    private static final String ACCOUNT_ATT = "account";
    
    public boolean checkSession (HttpServletRequest request){
        HttpSession session = request.getSession();
        return (session.getAttribute(ACCOUNT_ATT) == null || session.getAttribute(ACCOUNT_ATT) == "");
    }
    
    public void clearCache(HttpServletResponse response) {
        response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
        response.setHeader("Progma","no-cache");
        response.setDateHeader("Expires",0);
    }
    
    public void setSessionAttribute (HttpServletRequest request, AccountDTO accountDTO){
        HttpSession session = request.getSession();
        session.setAttribute(ACCOUNT_ATT,accountDTO);
    }
    
    public AccountDTO getSessionAttribute (HttpServletRequest request){
        HttpSession session = request.getSession();
        return (AccountDTO) session.getAttribute(ACCOUNT_ATT);
    }
    
    public void finishSession (HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
    }
}
