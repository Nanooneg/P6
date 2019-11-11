package com.nanoo.webapp.filter;

import com.nanoo.business.dto.AccountDTO;
import com.nanoo.webapp.util.Views;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/user/*")
public class Restriction implements Filter {
    
    /* Attributes names */
    private static final String ACCOUNT_SESSION_ATT = "accountSession";
    private static final String ACCOUNT_ATT = "account";
    
    private static final String LOGIN_JSP = "/WEB-INF/views/" + Views.LOGIN + ".jsp";
    
    @Override
    public void init(FilterConfig config) throws ServletException {
    
    }
    
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
    
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        
        //TODO not working
        response.setHeader("buffer","true");
        response.setHeader("ExpiresAbsolute","Now()-1");
        
        //Empty cache of browser to avoid user to get access to restricted pages after log out and press previous button
        response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); // HTTP 1.1
        response.setHeader("Pragma","no-cache"); // HTTP 1.0
        response.setDateHeader("Expires",0); // Proxies
    
        HttpSession session = request.getSession(false);
        
        if (session.getAttribute(ACCOUNT_SESSION_ATT) == null){
            request.setAttribute(ACCOUNT_ATT,new AccountDTO());
            request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
        }else {
            chain.doFilter(request, response);
        }
    }
    
    @Override
    public void destroy() {
    }
    
}
