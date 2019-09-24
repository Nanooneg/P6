package com.nanoo.business.mapper;

import com.nanoo.business.dto.SectorDTO;
import com.nanoo.model.entities.Sector;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author nanoo
 * @create 24/09/2019 - 10:16
 */
@Mapper(componentModel = "spring")
public interface SectorMapper {
    
    SectorMapper MAPPER = Mappers.getMapper(SectorMapper.class);
    
    Sector fromDtoToSector (SectorDTO sectorDTO);
    
    @InheritInverseConfiguration
    SectorDTO fromSectorToDto (Sector sector);
    
}
