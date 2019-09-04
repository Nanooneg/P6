package com.nanoo.webapp.controller;

import com.nanoo.business.serviceContrat.CityService;
import com.nanoo.model.entities.user.CityCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author nanoo
 * @create 01/09/2019 - 15:03
 */
@Controller
public class WebController {
    
    @Autowired
    CityService cityService;
    
    @RequestMapping("/")
    public ModelAndView home(){
    
    
        ModelAndView mav = new ModelAndView("index");
    
        /*Test*/
        System.out.println("Test entrée home");
        
        //mav.addObject("message", "Salut test");
        
        return mav;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String testSaveData(CityCode cityCode, @RequestParam(name = "city") String city, @RequestParam(name = "postalCode") int postalCode){
    
        /*Test*/
        System.out.println("Test entrée testSaveData");
        System.out.println(city);
        System.out.println(postalCode);
    
        cityCode.setCity(city);
        cityCode.setPostalCode(postalCode);
        cityService.saveTest(cityCode);
        
        return "index";
        }
    
}
