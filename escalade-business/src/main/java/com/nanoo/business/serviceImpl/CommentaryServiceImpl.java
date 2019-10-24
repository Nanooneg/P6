package com.nanoo.business.serviceImpl;

import com.nanoo.business.dto.AccountDTO;
import com.nanoo.business.dto.CommentaryDTO;
import com.nanoo.business.mapper.CommentaryMapper;
import com.nanoo.business.serviceContract.AccountService;
import com.nanoo.business.serviceContract.CommentaryService;
import com.nanoo.business.util.DateUtil;
import com.nanoo.consumer.repository.CommentaryRepository;
import com.nanoo.model.entities.Commentary;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author nanoo
 * @create 03/10/2019 - 22:26
 */
@Service
@Transactional
@Data
public class CommentaryServiceImpl implements CommentaryService {
    
    private DateUtil date;
    
    private final AccountService accountService;
    
    private final CommentaryRepository commentaryRepository;
    
    private final CommentaryMapper commentaryMapper;
    
    @Autowired
    public CommentaryServiceImpl(CommentaryRepository commentaryRepository, CommentaryMapper commentaryMapper, AccountService accountService) {
        this.commentaryRepository = commentaryRepository;
        this.commentaryMapper = commentaryMapper;
        this.accountService = accountService;
    }
    
    
    /**
     * This method search all commentary associated with a particular publication.
     *
     * @param publicationId id of the publication we are looking commentaries for
     * @return a map with commentary in key and the account who publish it in value
     */
    @Override
    public Map<CommentaryDTO, AccountDTO> findAllCommentaryOfPublicationId(String publicationId) {
        List<Commentary> commentariesList =
                commentaryRepository.findAllByIdPublication(Integer.parseInt(publicationId), Sort.by("dateOfPublication").descending());
        Map<CommentaryDTO, AccountDTO> commentariesAndAccountIdDtoList = new HashMap<>();
        
        for (Commentary commentary : commentariesList){
            
            commentariesAndAccountIdDtoList.put(commentaryMapper.fromCommentaryToDto(commentary),
                                                accountService.searchAccountLightById(commentary.getIdAccount()));
        }
        
        return commentariesAndAccountIdDtoList;
    }
    
    /**
     * This method save a comment in DB
     *
     * @param commentaryDTO commentary to save
     */
    @Override
    public void saveComment(CommentaryDTO commentaryDTO) {
        date = new DateUtil();
        Commentary existingCommentary;
        
        Commentary commentary = commentaryMapper.fromDtoToCommentary(commentaryDTO);
    
        if(commentary.getId() != null){
            Optional<Commentary> oldCommentary = commentaryRepository.findById(commentary.getId());
            if(oldCommentary.isPresent()){
                existingCommentary = oldCommentary.get();
                commentary.setDateOfPublication(existingCommentary.getDateOfPublication());
                commentary.setIdAccount(existingCommentary.getIdAccount());
            }
        }else {
            commentary.setDateOfPublication(new Date());
        }
        
        commentary.setDateOfModification(new Date());
        
        commentaryRepository.save(commentary);
    }
    
    /**
     * This method delete a comment from DB
     *
     * @param commentaryId id of the commentary to delete
     */
    @Override
    public void deleteCommentById(int commentaryId) {
        commentaryRepository.deleteById(commentaryId);
    }
    
    /**
     * This method search a distinct commentary in DB.
     *
     * @param commentaryId id of the commentary searched
     * @return the commentary searched if exist
     */
    @Override
    public CommentaryDTO searchCommentaryById(int commentaryId) {
        Optional<Commentary> commentary = commentaryRepository.findById(commentaryId);
    
        if (commentary.isPresent()) {
            Commentary existingCommentary = commentary.get();
            return commentaryMapper.fromCommentaryToDto(existingCommentary);
        }
    
        return null;
    }
    
    /**
     * This method delete all comment attached to a publication
     *
     * @param publicationId id of publication
     */
    @Override
    public void deleteCommentByPublicationId(int publicationId) {
        
        commentaryRepository.deleteAllByIdPublication(publicationId);
        
    }
}
