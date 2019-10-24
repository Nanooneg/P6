package com.nanoo.business.mapper;

import com.nanoo.business.dto.AccountSessionDTO;
import com.nanoo.model.entities.Account;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author nanoo
 * @create 23/10/2019 - 16:53
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AccountSessionMapper {
    
    AccountSessionMapper MAPPER = Mappers.getMapper(AccountSessionMapper.class);
    
    Account fromSessionDtoToAccount (AccountSessionDTO accountSessionDTO);
    
    @InheritInverseConfiguration
    AccountSessionDTO fromAccountToSessionDto (Account account);
    
}
