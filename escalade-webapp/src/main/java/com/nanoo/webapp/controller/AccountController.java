package com.nanoo.webapp.controller;

import com.nanoo.model.entities.EnumTitle;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * @author nanoo
 * @create 07/09/2019 - 12:01
 */
@Controller
public class AccountController {

    @RequestMapping("/login")
    public ModelAndView testBootstrap(){
        return new ModelAndView("login");
    }

    @RequestMapping("/register")
    public ModelAndView createAccount(){
        List<EnumTitle> listTitle = Arrays.asList(EnumTitle.values());
        
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("listTitle",listTitle);
        return mav;
    }
}
