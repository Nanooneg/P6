package com.nanoo.webapp.controller;

import com.nanoo.business.dto.AccountDTO;
import com.nanoo.business.dto.TopoBookingDTO;
import com.nanoo.business.dto.TopoDTO;
import com.nanoo.business.serviceContract.AccountService;
import com.nanoo.business.serviceContract.TopoService;
import com.nanoo.business.util.HandlingEnumValues;
import com.nanoo.business.util.SearchFilter;
import com.nanoo.webapp.util.SessionHandling;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @author nanoo
 * @create 23/09/2019 - 11:07
 */
@Controller
public class TopoController {
    
    private static final Logger log = LoggerFactory.getLogger(TopoController.class);
    
    private static final String TOPO_SEARCH_VIEW = "topoSpot";
    private static final String TOPO_VIEW = "topo";
    private static final String TOPO_FORM_VIEW = "topoForm";
    private static final String TOPOBOOKING_RECEIVED_ATT = "topoBookingReceived";
    private static final String TOPOBOOKING_SENT_ATT = "topoBookingSent";
    private static final String LOGIN_VIEW = "login";
    private static final String ASK_FOR_LENDING_VIEW = "askForLending";
    private static final String LENDING_REQUEST = "lendingRequest";
    
    private static final String ACCOUNT_ATT = "account";
    private static final String MESSAGE_ATT = "message";
    private static final String TOPO_ATT = "topo";
    private static final String REGION_ATT = "listRegion";
    private static final String CONDITION_ATT = "listCondition";
    private static final String SEARCH_ATT = "searchAttribut";
    private static final String SPOT_SERV_ATT = "saveTopo";
    private static final String LIST_TOPO_ATT = "listTopo";
    
    private static final String ALREADY_ASK_MESS = "Vous avez déjà une demande en attente pour ce topo. Si vous souaitez" +
                                    " en faire une nouvelle, supprimer d'abord l'ancienne depuis votre espace utilisateur";
    
    private HandlingEnumValues enumValues = new HandlingEnumValues();
    private List<String> listRegion = enumValues.getEnumRegionStringValues();
    private List<String> listCondition = enumValues.getEnumConditionStringValues();
    private SessionHandling sessionHandling;
    
    private final TopoService topoService;
    private final AccountService accountService;
    
    @Autowired
    public TopoController(TopoService topoService, AccountService accountService) {
        this.topoService = topoService;
        this.accountService = accountService;
    }
    
    
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping("/topoSpot")
    public String displayTopoPage (Model model){
    
        List<TopoDTO> topoDTOList = topoService.findAllTopo();
        model.addAttribute(SEARCH_ATT,new SearchFilter());
        model.addAttribute(REGION_ATT,listRegion);
        model.addAttribute(LIST_TOPO_ATT,topoDTOList);
        
        return TOPO_SEARCH_VIEW;
    }
    
    @PostMapping("/topoSpot")
    public String displayTopoPageWithSearchResult(@ModelAttribute SearchFilter filter, Model model){
    
        List<TopoDTO> topoDTOList = topoService.searchTopoByFilter(filter);
        
        model.addAttribute(MESSAGE_ATT, topoService.getResult());
        model.addAttribute(SEARCH_ATT,filter);
        model.addAttribute(REGION_ATT,listRegion);
        model.addAttribute(LIST_TOPO_ATT,topoDTOList);
        
        return TOPO_SEARCH_VIEW;
    }
    
    @GetMapping("/topoForm")
    public String displayTopoForm (HttpServletRequest request, Model model){
    
        /* Check if user has access */
        sessionHandling = new SessionHandling();
        if (sessionHandling.checkSession(request)){
            model.addAttribute(ACCOUNT_ATT,new AccountDTO());
            return LOGIN_VIEW;
        }
    
        model.addAttribute(TOPO_ATT,new TopoDTO());
        model.addAttribute(REGION_ATT,listRegion);
        model.addAttribute(CONDITION_ATT,listCondition);
        
        return TOPO_FORM_VIEW;
    }
    
    @GetMapping("/topo/{topoId}")
    public String displayTopo (@PathVariable String topoId, Model model){
        
        TopoDTO topoDTO = topoService.searchTopoById(Integer.parseInt(topoId));
        AccountDTO accountDTO = accountService.searchAccountLightById(topoDTO.getIdAccount());
        
        model.addAttribute(TOPO_ATT, topoDTO);
        model.addAttribute(ACCOUNT_ATT,accountDTO);
        
        return TOPO_VIEW;
    }
    
    @PostMapping({"/saveTopo/","/saveTopo/{topoId}"})
    public String saveTopo(@Valid @ModelAttribute("topo") TopoDTO topoDTO,
                           BindingResult bResult, HttpServletRequest request,
                           Model model, @PathVariable(required = false) String topoId){
        
        sessionHandling = new SessionHandling();
        
        if (bResult.hasErrors()){
            model.addAttribute(TOPO_ATT,topoDTO);
            model.addAttribute(REGION_ATT,listRegion);
            model.addAttribute(CONDITION_ATT,listCondition);
            model.addAttribute(SPOT_SERV_ATT, topoService);
            
            return TOPO_FORM_VIEW;
        }
    
        AccountDTO accountDTOLight = sessionHandling.getSessionAttribute(request);
    
        if (topoId != null)
            topoDTO.setId(Integer.parseInt(topoId));
        else
            topoDTO.setIdAccount(accountDTOLight.getId());
        
        topoService.saveTopo(topoDTO);
        
        return displayTopoPage(model);
    }
    
    @GetMapping("/updateTopo/{topoId}")
    public String updateTopo(@PathVariable String topoId, Model model){
        
        model.addAttribute(TOPO_ATT, topoService.searchTopoById(Integer.parseInt(topoId)));
        model.addAttribute(REGION_ATT,listRegion);
        model.addAttribute(CONDITION_ATT,listCondition);
        
        return TOPO_FORM_VIEW;
    }
    
    @GetMapping("/deleteTopo/{topoId}")
    public String deleteTopo(@PathVariable String topoId, Model model){
        
        topoService.deleteTopo(Integer.parseInt(topoId));
        
        return displayTopoPage(model);
    }
    
    @GetMapping("/askForLending/{topoId}")
    public String askForLending(HttpServletRequest request, Model model, @PathVariable String topoId){
    
        /* Check if user has access */
        sessionHandling = new SessionHandling();
        if (sessionHandling.checkSession(request)){
            model.addAttribute(ACCOUNT_ATT,new AccountDTO());
            return LOGIN_VIEW;
        }
        
        model.addAttribute(TOPO_ATT,topoService.searchTopoById(Integer.parseInt(topoId)));
        
        return ASK_FOR_LENDING_VIEW;
    }
    
    @GetMapping("/validAskForLending/{accountId}/{topoId}")
    public String createTopoBooking(HttpServletRequest request, Model model, @PathVariable String accountId, @PathVariable String topoId){
        
        if (!topoService.checkTopoBookingAskRequest(accountId,topoId)) {
            model.addAttribute(MESSAGE_ATT,ALREADY_ASK_MESS);
            return askForLending(request,model,topoId);
        }
        topoService.saveTopoBooking(Integer.parseInt(accountId),Integer.parseInt(topoId));
        
        return displayTopo(topoId,model);
    }
    
    @GetMapping("/lendingRequestReceived/{userId}")
    public String displayLendingRequestReceived(@PathVariable String userId, Model model){
    
        List<TopoBookingDTO> topoBookingReceivedDTOList = topoService.searchAllTopoBookingByTopoAccountId(Integer.parseInt(userId));
        List<TopoBookingDTO> topoBookingSentDTOList = topoService.searchAllTopoBookingByAccountId(Integer.parseInt(userId));
    
        model.addAttribute(TOPOBOOKING_RECEIVED_ATT, topoBookingReceivedDTOList);
        model.addAttribute(TOPOBOOKING_SENT_ATT, topoBookingSentDTOList);
        
        return LENDING_REQUEST;
    }
    
    @GetMapping("/validLendingRequest/{userId}/{topoBookingId}/{answer}")
    public String giveAnswerToLendingRequest(@PathVariable String topoBookingId, @PathVariable String answer, Model model, @PathVariable String userId){
        
        topoService.changeStatus(userId,topoBookingId,answer);
        
        return displayLendingRequestReceived(userId,model);
    }
    
    @GetMapping("/deleteTopoBooking/{userId}/{topoBookingId}")
    public String deleteTopoBooking(@PathVariable String userId, @PathVariable String topoBookingId, Model model){
        
        topoService.deleteTopoBooking(Integer.parseInt(topoBookingId));
        
        return displayLendingRequestReceived(userId, model);
    }
    
}
