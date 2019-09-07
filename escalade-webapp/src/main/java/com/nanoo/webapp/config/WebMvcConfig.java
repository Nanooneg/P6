package com.nanoo.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author nanoo
 * @create 01/09/2019 - 14:39
 */
@Configuration
@ComponentScan("com.nanoo.webapp")
public class WebMvcConfig {

    @Bean
    public InternalResourceViewResolver viewResolver () {
    
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
    
        return viewResolver;
    }

}
