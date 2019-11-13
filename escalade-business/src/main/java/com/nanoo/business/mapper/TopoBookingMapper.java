package com.nanoo.business.mapper;

import com.nanoo.business.dto.TopoBookingDTO;
import com.nanoo.model.entities.TopoBooking;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author nanoo
 * @create 16/10/2019 - 13:58
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TopoBookingMapper {
    
    TopoBookingMapper MAPPER = Mappers.getMapper(TopoBookingMapper.class);
    
    TopoBooking fromDtoToTopoBooking (TopoBookingDTO topoBookingDTO);
    
    @InheritInverseConfiguration
    TopoBookingDTO fromTopoBookingToDto (TopoBooking topoBooking);
    
    
}
