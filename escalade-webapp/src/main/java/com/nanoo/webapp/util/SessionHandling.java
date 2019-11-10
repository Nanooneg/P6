package com.nanoo.webapp.util;

import javax.servlet.http.HttpServletResponse;

/**
 * @author nanoo
 * @create 24/09/2019 - 10:46
 */
public class SessionHandling {
    
    private SessionHandling() {}
    
    /**
     * This method is used to clear the cache of browser. When user use previous button" after log out
     * it avoid to get back in logged status.
     *
     * @param response httpResponse who contain parameter used to clear the cache
     */
    public static void clearCache(HttpServletResponse response) {
        response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); // HTTP 1.1
        response.setHeader("Pragma","no-cache"); // HTTP 1.0
        response.setHeader("Expires","0"); // Proxies
    }
    
}
