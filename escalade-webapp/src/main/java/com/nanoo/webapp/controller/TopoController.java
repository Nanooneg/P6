package com.nanoo.webapp.controller;

import com.nanoo.business.dto.AccountDTO;
import com.nanoo.business.dto.AccountSessionDTO;
import com.nanoo.business.dto.TopoBookingDTO;
import com.nanoo.business.dto.TopoDTO;
import com.nanoo.business.serviceContract.AccountService;
import com.nanoo.business.serviceContract.TopoBookingService;
import com.nanoo.business.serviceContract.TopoService;
import com.nanoo.business.util.HandlingEnumValues;
import com.nanoo.business.util.SearchFilter;
import com.nanoo.webapp.util.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author nanoo
 * @create 23/09/2019 - 11:07
 */
@Controller
public class TopoController {
    
    private static final String ACCOUNT_ATT = "account";
    private static final String MESSAGE_ATT = "message";
    private static final String TOPO_ATT = "topo";
    private static final String TOPOBOOKING_RECEIVED_ATT = "topoBookingReceived";
    private static final String TOPOBOOKING_SENT_ATT = "topoBookingSent";
    private static final String REGION_ATT = "listRegion";
    private static final String CONDITION_ATT = "listCondition";
    private static final String SEARCH_ATT = "searchAttribut";
    private static final String SPOT_SERV_ATT = "saveTopo";
    private static final String LIST_TOPO_ATT = "listTopo";
    
    private static final String ALREADY_ASK_MESS = "Vous avez déjà une demande en attente pour ce topo. Si vous souaitez" +
                                    " en faire une nouvelle, supprimer d'abord l'ancienne depuis votre espace utilisateur";
    
    private List<String> listRegion = HandlingEnumValues.getEnumRegionStringValues();
    private List<String> listCondition = HandlingEnumValues.getEnumConditionStringValues();
    
    private final TopoService topoService;
    private final TopoBookingService topoBookingService;
    private final AccountService accountService;
    
    @Autowired
    public TopoController(TopoService topoService, TopoBookingService topoBookingService, AccountService accountService) {
        this.topoService = topoService;
        this.topoBookingService = topoBookingService;
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
        
        return Views.TOPO_SEARCH;
    }
    
    @PostMapping("/topoSpot")
    public String displayTopoPageWithSearchResult(@ModelAttribute SearchFilter filter, Model model){
    
        List<TopoDTO> topoDTOList = topoService.searchTopoByFilter(filter);
        
        model.addAttribute(MESSAGE_ATT, topoService.getResult());
        model.addAttribute(SEARCH_ATT,filter);
        model.addAttribute(REGION_ATT,listRegion);
        model.addAttribute(LIST_TOPO_ATT,topoDTOList);
        
        return Views.TOPO_SEARCH;
    }
    
    @GetMapping("/topoForm")
    public String displayTopoForm (Model model,
                                   @SessionAttribute(value = "accountSession", required = false) AccountSessionDTO accountSessionDTO){
        
        if (accountSessionDTO == null){
            model.addAttribute(ACCOUNT_ATT,new AccountDTO());
            return Views.LOGIN;
        }
    
        model.addAttribute(TOPO_ATT,new TopoDTO());
        model.addAttribute(REGION_ATT,listRegion);
        model.addAttribute(CONDITION_ATT,listCondition);
        
        return Views.TOPO_FORM;
    }
    
    @GetMapping("/topo/{topoId}")
    public String displayTopo (@PathVariable String topoId, Model model){
        
        TopoDTO topoDTO = topoService.searchTopoById(Integer.parseInt(topoId));
        AccountDTO accountDTO = accountService.searchAccountLightById(topoDTO.getIdAccount());
        
        model.addAttribute(TOPO_ATT, topoDTO);
        model.addAttribute(ACCOUNT_ATT,accountDTO);
        
        return Views.TOPO;
    }
    
    @PostMapping({"/saveTopo/","/saveTopo/{topoId}"})
    public String saveTopo(@Valid @ModelAttribute("topo") TopoDTO topoDTO,
                           @SessionAttribute(value = "accountSession") AccountSessionDTO accountSessionDTO,
                           BindingResult bResult, Model model, @PathVariable(required = false) String topoId){
        
        if (bResult.hasErrors()){
            model.addAttribute(TOPO_ATT,topoDTO);
            model.addAttribute(REGION_ATT,listRegion);
            model.addAttribute(CONDITION_ATT,listCondition);
            model.addAttribute(SPOT_SERV_ATT, topoService);
            
            return Views.TOPO_FORM;
        }
        
        if (topoId != null)
            topoDTO.setId(Integer.parseInt(topoId));
        else
            topoDTO.setIdAccount(accountSessionDTO.getId());
        
        topoService.saveTopo(topoDTO);
        
        return displayTopoPage(model);
    }
    
    @GetMapping("/updateTopo/{topoId}")
    public String updateTopo(@PathVariable String topoId, Model model){
        
        model.addAttribute(TOPO_ATT, topoService.searchTopoById(Integer.parseInt(topoId)));
        model.addAttribute(REGION_ATT,listRegion);
        model.addAttribute(CONDITION_ATT,listCondition);
        
        return Views.TOPO_FORM;
    }
    
    @GetMapping("/deleteTopo/{topoId}")
    public String deleteTopo(@PathVariable String topoId, Model model){
        
        topoService.deleteTopo(Integer.parseInt(topoId));
        
        return displayTopoPage(model);
    }
    
    @GetMapping("/askForLending/{topoId}")
    public String askForLending(Model model, @PathVariable String topoId,
                                @SessionAttribute(value = "accountSession", required = false)AccountSessionDTO accountSessionDTO){

        if (accountSessionDTO == null){
            model.addAttribute(ACCOUNT_ATT,new AccountDTO());
            return Views.LOGIN;
        }
        
        model.addAttribute(TOPO_ATT,topoService.searchTopoById(Integer.parseInt(topoId)));
        
        return Views.ASK_FOR_LENDING;
    }
    
    @GetMapping("/validAskForLending/{accountId}/{topoId}")
    public String createTopoBooking(Model model, @PathVariable String accountId, @PathVariable String topoId,
                                    @SessionAttribute(value = "accountSession")AccountSessionDTO accountSessionDTO){
        
        if (!topoBookingService.checkTopoBookingAskRequest(accountId,topoId)) {
            model.addAttribute(MESSAGE_ATT,ALREADY_ASK_MESS);
            return askForLending(model,topoId,accountSessionDTO);
        }
        topoBookingService.saveTopoBooking(Integer.parseInt(accountId),Integer.parseInt(topoId));
        
        return displayTopo(topoId,model);
    }
    
    @GetMapping("/lendingRequestReceived/{userId}")
    public String displayLendingRequestReceived(@PathVariable String userId, Model model){
    
        List<TopoBookingDTO> topoBookingReceivedDTOList =
                topoBookingService.searchAllTopoBookingByIdOwner(Integer.parseInt(userId));
        List<TopoBookingDTO> topoBookingSentDTOList =
                topoBookingService.searchAllTopoBookingByIdBorrower(Integer.parseInt(userId));
    
        model.addAttribute(TOPOBOOKING_RECEIVED_ATT, topoBookingReceivedDTOList);
        model.addAttribute(TOPOBOOKING_SENT_ATT, topoBookingSentDTOList);
        
        return Views.LENDING_REQUEST;
    }
    
    @GetMapping("/validLendingRequest/{userId}/{topoBookingId}/{answer}")
    public String giveAnswerToLendingRequest(@PathVariable String topoBookingId,
                                             @PathVariable String answer, Model model,
                                             @PathVariable String userId){
    
        topoBookingService.changeStatus(userId,topoBookingId,answer);
        
        return displayLendingRequestReceived(userId,model);
    }
    
    @GetMapping("/deleteTopoBooking/{userId}/{topoBookingId}")
    public String deleteTopoBooking(@PathVariable String userId, @PathVariable String topoBookingId, Model model){
    
        topoBookingService.deleteTopoBooking(Integer.parseInt(topoBookingId));
        
        return displayLendingRequestReceived(userId, model);
    }
    
}
