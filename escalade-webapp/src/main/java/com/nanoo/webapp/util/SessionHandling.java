package com.nanoo.webapp.util;

import javax.servlet.http.HttpServletResponse;

/**
 * @author nanoo
 * @create 24/09/2019 - 10:46
 */
public class SessionHandling {
    
    /**
     * This method is used to clear the cache of browser. When user use éprevious button" after log out
     * it avoid to get back in logged status.
     *
     * @param response httpResponse who contain parameter used to clear the cache
     */
    public void clearCache(HttpServletResponse response) {
        response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
        response.setHeader("Progma","no-cache");
        response.setDateHeader("Expires",0);
    }

}
