package com.nanoo.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author nanoo
 * @create 23/09/2019 - 11:07
 */
@Controller
public class TopoController {
    
    private static final String TOPO_VIEW = "topo";

    @GetMapping("/topo")
    public String displayTopoPage (){
        return TOPO_VIEW;
    }
    
}
