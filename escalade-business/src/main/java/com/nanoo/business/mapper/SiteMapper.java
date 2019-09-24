package com.nanoo.business.mapper;

import com.nanoo.business.dto.SiteDTO;
import com.nanoo.model.entities.Site;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author nanoo
 * @create 24/09/2019 - 10:02
 */
@Mapper(componentModel = "spring")
public interface SiteMapper {
    
    SiteMapper MAPPER = Mappers.getMapper(SiteMapper.class);
    
    Site fromDtoToSite (SiteDTO siteDTO);
    
    @InheritInverseConfiguration
    SiteDTO fromSiteToDto (Site site);
    
}
