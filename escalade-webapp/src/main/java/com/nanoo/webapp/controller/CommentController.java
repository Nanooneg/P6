package com.nanoo.webapp.controller;

import com.nanoo.business.dto.AccountDTO;
import com.nanoo.business.dto.CommentaryDTO;
import com.nanoo.business.serviceContract.CommentaryService;
import com.nanoo.webapp.util.SessionHandling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;

/**
 * @author nanoo
 * @create 03/10/2019 - 22:20
 */
@Controller
public class CommentController {
    
    private static final String COMMENTARY_VIEW = "commentary";
    private static final String COMMENTARY_FORM_VIEW = "commentaryForm";
    private static final String LOGIN_VIEW = "login";
    
    private static final String ACCOUNT_ATT = "account";
    private static final String MESSAGE_ATT = "message";
    private static final String PUBLICATION_ID_ATT = "publicationId";
    private static final String COMMENTARY_ID_ATT = "commentaryId";
    private static final String COMMENTARY_LIST_ATT = "listCommentaries";
    private static final String COMMENTARY_ATT = "commentary";
    
    @Autowired CommentaryService commentaryService;
    
    private SessionHandling sessionHandling;
    
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
    
    @GetMapping("/commentary/{publicationId}")
    public String displayCommentaryView(@PathVariable String publicationId, Model model){
    
        Map<CommentaryDTO,AccountDTO> commentariedDTOList = commentaryService.findAllCommentaryOfPublicationId(publicationId);
        model.addAttribute(COMMENTARY_LIST_ATT,commentariedDTOList);
        model.addAttribute(PUBLICATION_ID_ATT, publicationId);
        
        return COMMENTARY_VIEW;
    }
    
    @GetMapping("/addComment/{publicationId}")
    public String displayCommentForm(@PathVariable String publicationId, Model model, HttpServletRequest request){
    
        /* Check if user has access */
        sessionHandling = new SessionHandling();
        if (sessionHandling.checkSession(request)){
            model.addAttribute(ACCOUNT_ATT,new AccountDTO());
            return LOGIN_VIEW;
        }
        
        model.addAttribute(COMMENTARY_ATT, new CommentaryDTO());
        model.addAttribute(PUBLICATION_ID_ATT, publicationId);
    
        return COMMENTARY_FORM_VIEW;
    }
    
    @GetMapping("/updateCommentary/{publicationId}/{commentaryId}")
    public String updateCommentary(@PathVariable String commentaryId, Model model, @PathVariable String publicationId){
        
        CommentaryDTO commentaryDTO = commentaryService.searchCommentaryById(Integer.parseInt(commentaryId));
        
        model.addAttribute(COMMENTARY_ATT, commentaryDTO);
        model.addAttribute(PUBLICATION_ID_ATT, publicationId);
        model.addAttribute(COMMENTARY_ID_ATT, commentaryId);
        
        return COMMENTARY_FORM_VIEW;
    }
    
    @PostMapping({"/saveComment/{publicationId}/","/saveComment/{publicationId}/{commentaryId}"})
    public String addCommentAndDisplayCommentaryView(@Valid @ModelAttribute("commentary") CommentaryDTO commentaryDTO,
                                                     BindingResult br, Model model, HttpServletRequest request,
                                                     @PathVariable String publicationId,
                                                     @PathVariable (required = false) String commentaryId){
        
        if (br.hasErrors()) {
            model.addAttribute(COMMENTARY_ATT,commentaryDTO);
            model.addAttribute(MESSAGE_ATT, "L'ajout a échoué");
            return COMMENTARY_FORM_VIEW;
        }
        
        HttpSession session = request.getSession();
        AccountDTO accountDTO = (AccountDTO) session.getAttribute(ACCOUNT_ATT);
    
        if (commentaryId != null)
            commentaryDTO.setId(Integer.parseInt(commentaryId));
        else
            commentaryDTO.setIdAccount(accountDTO.getId());
        
        commentaryDTO.setIdPublication(Integer.parseInt(publicationId));
        commentaryService.saveComment(commentaryDTO);
        
        return displayCommentaryView(publicationId, model);
    }
    
    @GetMapping("/deleteCommentary/{publicationId}/{commentaryId}")
    public String deleteCommentAnsDisplayCommentaryView(@PathVariable String publicationId, @PathVariable String commentaryId,
                                                        Model model){
        commentaryService.deleteCommentById(Integer.parseInt(commentaryId));
        
        return displayCommentaryView(publicationId,model);
    }
    
}
