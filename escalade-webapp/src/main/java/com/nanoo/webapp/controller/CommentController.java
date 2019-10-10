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
    private static final String COMMENTARY_LIST_ATT = "listCommentaries";
    private static final String COMMENTARY_ATT = "commentary";
    
    @Autowired
    CommentaryService commentaryService;
    
    SessionHandling sessionHandling;
    
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    
    @GetMapping("/commentary/{publicationId}")
    public String displayCommentaryView(@PathVariable String publicationId, Model model){
    
        Map<CommentaryDTO,AccountDTO> commentariedDTOList = commentaryService.findAllCommentaryOfPublicationId(publicationId);
        model.addAttribute(COMMENTARY_LIST_ATT,commentariedDTOList);
        
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
        
        return COMMENTARY_FORM_VIEW;
    }
    
    @PostMapping("/addComment/{publicationId}")
    public String addCommentAndDisplayCommentaryView(@Valid @ModelAttribute("commentary")CommentaryDTO commentaryDTO,
                                                     BindingResult br, @PathVariable String publicationId, Model model,
                                                     HttpServletRequest request){
        if (!br.hasErrors()) {
            //TODO write method to get accountId
            HttpSession session = request.getSession();
            AccountDTO accountDTO = (AccountDTO) session.getAttribute(ACCOUNT_ATT);

            commentaryDTO.setIdAccount(accountDTO.getId());
            commentaryDTO.setIdTypeOfComment(Integer.parseInt(publicationId));
            commentaryService.addComment(commentaryDTO);
            return displayCommentaryView(publicationId, model);
        }else {
            model.addAttribute(COMMENTARY_ATT,commentaryDTO);
            return COMMENTARY_FORM_VIEW;
        }
    }
    
}
