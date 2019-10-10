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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author nanoo
 * @create 03/10/2019 - 22:26
 */
@Service
@Transactional
@Data
public class CommentaryServiceImpl implements CommentaryService {
    
    @Autowired
    CommentaryRepository commentaryRepository;
    
    @Autowired
    CommentaryMapper commentaryMapper;
    
    @Autowired
    private AccountService accountService;
    
    private DateUtil date;
    
    /**
     * @param id
     *
     * @return
     */
    @Override
    public Map<CommentaryDTO, AccountDTO> findAllCommentaryOfPublicationId(String id) {
        List<Commentary> commentariesList = commentaryRepository.findAllByIdTypeOfComment(Integer.parseInt(id));
        Map<CommentaryDTO, AccountDTO> commentariesAndAccountIdDtoList = new HashMap<>();
        
        for (Commentary commentary : commentariesList){
            
            commentariesAndAccountIdDtoList.put(commentaryMapper.fromCommentaryToDto(commentary),
                                                accountService.searchAccountLightById(commentary.getIdAccount()));
        }
        
        return commentariesAndAccountIdDtoList;
    }
    
    /**
     * @param commentaryDTO
     */
    @Override
    public void addComment(CommentaryDTO commentaryDTO) {
        date = new DateUtil();
        
        commentaryDTO.setDateOfPublication(date.getCurrentDateTime());
        commentaryDTO.setDateOfModification(commentaryDTO.getDateOfPublication());
        commentaryRepository.save(commentaryMapper.fromDtoToCommentary(commentaryDTO));
        
    }
}
