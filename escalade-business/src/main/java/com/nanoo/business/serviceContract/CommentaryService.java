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
     *
     * @param id
     * @return
     */
    Map<CommentaryDTO, AccountDTO> findAllCommentaryOfPublicationId(String id);
    
    /**
     *
     * @param commentaryDTO
     */
    void addComment(CommentaryDTO commentaryDTO);
}
