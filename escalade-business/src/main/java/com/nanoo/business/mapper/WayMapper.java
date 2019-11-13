package com.nanoo.business.mapper;

import com.nanoo.business.dto.WayDTO;
import com.nanoo.model.entities.Way;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author nanoo
 * @create 24/09/2019 - 10:25
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface WayMapper {
    
    WayMapper MAPPER = Mappers.getMapper(WayMapper.class);
    
    Way fromDtoToWay (WayDTO wayDTO);
    
    @InheritInverseConfiguration
    WayDTO fromWayToDto (Way way);
    
}
