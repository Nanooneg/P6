package com.nanoo.model.mapper;

import com.nanoo.model.DTO.AccountDTO;
import com.nanoo.model.entities.Account;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author nanoo
 * @create 16/09/2019 - 11:05
 */
@Mapper(componentModel = "spring")
public interface AccountMapper {
    
    AccountMapper MAPPER = Mappers.getMapper(AccountMapper.class);
    
    Account fromDtoToAccount (AccountDTO accountDTO);
    
    @InheritInverseConfiguration
    AccountDTO fromAccountToDto (Account account);
    
}
