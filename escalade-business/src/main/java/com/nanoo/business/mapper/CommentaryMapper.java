package com.nanoo.business.mapper;

import com.nanoo.business.dto.CommentaryDTO;
import com.nanoo.model.entities.Commentary;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author nanoo
 * @create 03/10/2019 - 22:09
 */
@Mapper(componentModel = "spring")
public interface CommentaryMapper {
    
    CommentaryMapper MAPPER = Mappers.getMapper(CommentaryMapper.class);
    
    Commentary fromDtoToCommentary (CommentaryDTO commentaryDTO);
    
    @InheritInverseConfiguration
    CommentaryDTO fromCommentaryToDto (Commentary commentary);
    
}
