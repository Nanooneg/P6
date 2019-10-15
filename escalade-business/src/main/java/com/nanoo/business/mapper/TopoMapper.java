package com.nanoo.business.mapper;

import com.nanoo.business.dto.TopoDTO;
import com.nanoo.model.entities.Topo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author nanoo
 * @create 14/10/2019 - 10:45
 */
@Mapper(componentModel = "spring")
public interface TopoMapper {
    
    TopoMapper MAPPER = Mappers.getMapper(TopoMapper.class);
    
    //@Mapping(source = "dateOfPublication", target = "dateOfPublication", dateFormat = "dd/MM/yyyy")
    Topo fromDtoToTopo (TopoDTO topoDTO);
    
    @InheritInverseConfiguration
    TopoDTO fromTopoToDto (Topo topo);
    
}
