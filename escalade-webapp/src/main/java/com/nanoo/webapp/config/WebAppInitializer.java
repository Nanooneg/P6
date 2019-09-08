package com.nanoo.webapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author nanoo
 * @create 01/09/2019 - 14:36
 */
@Configuration
@EnableWebMvc
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
   
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }
    
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcConfig.class};
    }
    
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
    
}
