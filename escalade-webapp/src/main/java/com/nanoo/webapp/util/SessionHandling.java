package com.nanoo.webapp.util;

import javax.servlet.http.HttpServletRequest;
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
    
}
