package com.nanoo.webapp.controller;

import com.nanoo.business.serviceContract.AccountService;
import com.nanoo.model.entities.Account;
import com.nanoo.model.entities.Address;
import com.nanoo.model.entities.EnumRole;
import com.nanoo.model.entities.EnumTitle;
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
public class TestController {
    
    @Autowired
    private AccountService accountService;
    
    
    @RequestMapping("/")
    public ModelAndView home(){
    
    
        ModelAndView mav = new ModelAndView("index");
    
        /*Test*/
        System.out.println("Test entrée home");
        
        //mav.addObject("message", "Salut test");
        
        return mav;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String testSaveData(Account account, Address address,
                               @RequestParam(name = "city") String city,
                               @RequestParam(name = "postalCode") int postalCode){
    
        /*Test*/
        System.out.println("Test entrée testSaveData");
        System.out.println(city);
        System.out.println(postalCode);
    
        /*récupération des paramêtre et ajout de nouveau*/
        address.setStreetNbr("5");
        address.setStreetName("rue de la liberté");
        address.setPostalCode(postalCode);
        address.setCity(city);
        
        account.setTitle(EnumTitle.MR);
        account.setFirstName("Arnaud");
        account.setLastName("Laval");
        account.setMail("mail@test.fr");
        account.setAddress(address);
        account.setRoleName(EnumRole.ADMIN);
    
        /*Test de sauvegarde de données*/
        accountService.saveAccount(account);
        
        return "index";
        }
    
}