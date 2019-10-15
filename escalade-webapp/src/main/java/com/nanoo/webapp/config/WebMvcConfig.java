package com.nanoo.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author nanoo
 * @create 01/09/2019 - 14:39
 */
@Configuration
@ComponentScan("com.nanoo.webapp")
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
    
    private static final int MAX_UPLOAD_SIZE = 10 * 1024 * 1024;

    @Bean
    public InternalResourceViewResolver viewResolver () {
    
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setContentType("utf-8");
    
        return viewResolver;
    }
    
    
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(MAX_UPLOAD_SIZE);
        multipartResolver.setDefaultEncoding("utf-8");
        return multipartResolver;
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/","file:/home/nanoo/dev/static/picture/escalade-pictures/")
                .setCachePeriod(31556926);
    }
}
