package com.nanoo.business.mapper;

import com.nanoo.business.dto.AccountDTO;
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
    
    /* Custom mapping with only Id , firstname, lastname and role */
    default AccountDTO fromAccountToDtoLight (Account account){
        if ( account == null ) {
            return null;
        }
    
        AccountDTO accountDTO = new AccountDTO();
    
        accountDTO.setId( account.getId() );
        accountDTO.setFirstName( account.getFirstName() );
        accountDTO.setLastName( account.getLastName() );
        accountDTO.setRoleName( account.getRoleName() );
    
        return accountDTO;
    }
    
}
