package com.nanoo.webapp.controller;

import com.nanoo.business.serviceContrat.CityService;
import com.nanoo.model.entities.user.CityCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author nanoo
 * @create 01/09/2019 - 15:03
 */
@Controller
public class WebController {
    
    @Autowired private CityService cityService;
    
    @RequestMapping("/")
    public ModelAndView home(){
    
    
        ModelAndView mav = new ModelAndView("index");
    
        System.out.println("test entrée");
        CityCode cityCode = null;
        cityCode.setPostalCode(33000);
        cityCode.setCity("Bordeaux");
        cityService.saveTest(cityCode);
        System.out.println("test sortie");
        
        mav.addObject("message", "Salut test");
        
        return mav;
    }
    
}
