package com.nanoo.webapp.controller;

import com.nanoo.business.dto.AccountDTO;
import com.nanoo.business.dto.AccountSessionDTO;
import com.nanoo.business.dto.CommentaryDTO;
import com.nanoo.business.serviceContract.CommentaryService;
import com.nanoo.webapp.util.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * @author nanoo
 * @create 03/10/2019 - 22:20
 */
@Controller
public class CommentController {
    
    /* Attributes names */
    private static final String MESSAGE_ATT = "message";
    private static final String PUBLICATION_ID_ATT = "publicationId";
    private static final String PUBLICATION_TYPE_ATT = "publicationType";
    private static final String COMMENTARY_ID_ATT = "commentaryId";
    private static final String COMMENTARY_LIST_ATT = "listCommentaries";
    private static final String COMMENTARY_ATT = "commentary";
    
    /* Redirection */
    private static final String LOGIN_REDIRECT = "redirect:/login";
    
    private final CommentaryService commentaryService;
    
    @Autowired
    public CommentController(CommentaryService commentaryService) {
        this.commentaryService = commentaryService;
    }
    
    
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
    
    @GetMapping("/commentary/{publicationType}/{publicationId}")
    public String displayCommentaryView(@PathVariable String publicationType, @PathVariable String publicationId, Model model){
    
        Map<CommentaryDTO,AccountDTO> commentariedDTOList = commentaryService.findAllCommentaryOfPublicationId(publicationId);
        model.addAttribute(COMMENTARY_LIST_ATT,commentariedDTOList);
        model.addAttribute(PUBLICATION_ID_ATT, publicationId);
        model.addAttribute(PUBLICATION_TYPE_ATT, publicationType);
        
        return Views.COMMENTARY;
    }
    
    @GetMapping("/addComment/{publicationType}/{publicationId}")
    public String displayCommentForm(@PathVariable String publicationType, @PathVariable String publicationId, Model model,
                                     @SessionAttribute(value = "accountSession", required = false)AccountSessionDTO accountSessionDTO){
        
        if (accountSessionDTO == null){
            return LOGIN_REDIRECT;
        }
        
        model.addAttribute(COMMENTARY_ATT, new CommentaryDTO());
        model.addAttribute(PUBLICATION_ID_ATT, publicationId);
        model.addAttribute(PUBLICATION_TYPE_ATT, publicationType);
    
        return Views.COMMENTARY_FORM;
    }
    
    @GetMapping("/updateCommentary/{publicationType}/{publicationId}/{commentaryId}")
    public String updateCommentary(@PathVariable String commentaryId, Model model,
                                   @PathVariable String publicationId, @PathVariable String publicationType){
        
        CommentaryDTO commentaryDTO = commentaryService.searchCommentaryById(Integer.parseInt(commentaryId));
        
        model.addAttribute(COMMENTARY_ATT, commentaryDTO);
        model.addAttribute(PUBLICATION_ID_ATT, publicationId);
        model.addAttribute(PUBLICATION_TYPE_ATT, publicationType);
        model.addAttribute(COMMENTARY_ID_ATT, commentaryId);
        
        return Views.COMMENTARY_FORM;
    }
    
    @PostMapping({"/saveComment/{publicationType}/{publicationId}/","/saveComment/{publicationType}/{publicationId}/{commentaryId}"})
    public String addCommentAndDisplayCommentaryView(@Valid @ModelAttribute("commentary") CommentaryDTO commentaryDTO,
                                                     BindingResult br, Model model,
                                                     @SessionAttribute ("accountSession") AccountSessionDTO accountSessionDTO,
                                                     @PathVariable String publicationType,
                                                     @PathVariable String publicationId,
                                                     @PathVariable(required = false) String commentaryId){
        
        if (br.hasErrors()) {
            model.addAttribute(COMMENTARY_ATT,commentaryDTO);
            model.addAttribute(MESSAGE_ATT, "L'ajout a échoué");
            return Views.COMMENTARY_FORM;
        }
        
        if (commentaryId != null)
            commentaryDTO.setId(Integer.parseInt(commentaryId));
        else
            commentaryDTO.setIdAccount(accountSessionDTO.getId());
        
        commentaryDTO.setIdPublication(Integer.parseInt(publicationId));
        
        commentaryService.saveComment(commentaryDTO);
    
        return displayCommentaryView(publicationType, publicationId, model);
    }
    
    @GetMapping("/deleteCommentary/{publicationType}/{publicationId}/{commentaryId}")
    public String deleteCommentAnsDisplayCommentaryView(@PathVariable String publicationId, @PathVariable String commentaryId,
                                                        Model model, @PathVariable String publicationType){
        
        commentaryService.deleteCommentById(Integer.parseInt(commentaryId));
        
        return displayCommentaryView(publicationType, publicationId, model);
    }
    
}
