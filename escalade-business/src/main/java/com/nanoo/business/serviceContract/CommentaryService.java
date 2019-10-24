package com.nanoo.business.serviceContract;

import com.nanoo.business.dto.AccountDTO;
import com.nanoo.business.dto.CommentaryDTO;

import java.util.Map;

/**
 * @author nanoo
 * @create 03/10/2019 - 22:27
 */
public interface CommentaryService {
    
    /**
     * This method search all commentary associated with a particular publication.
     *
     * @param publicationId id of the publication we are looking commentaries for
     * @return a map with commentary in key and the account who publish it in value
     */
    Map<CommentaryDTO, AccountDTO> findAllCommentaryOfPublicationId(String publicationId);
    
    /**
     * This method save a comment in DB
     *
     * @param commentaryDTO commentary to save
     */
    void saveComment(CommentaryDTO commentaryDTO);
    
    /**
     * This method delete a comment from DB
     *
     * @param commentaryId id of the commentary to delete
     */
    void deleteCommentById (int commentaryId);
    
    /**
     * This method search a distinct commentary in DB.
     *
     * @param commentaryId id of the commentary searched
     * @return the commentary searched if exist
     */
    CommentaryDTO searchCommentaryById(int commentaryId);
    
    /**
     * This method delete all comment attached to a publication
     *
     * @param publicationId id of publication
     */
    void deleteCommentByPublicationId(int publicationId);
}
