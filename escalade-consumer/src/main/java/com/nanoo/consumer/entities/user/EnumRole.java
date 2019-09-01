package com.nanoo.consumer.entities.user;

import org.springframework.stereotype.Component;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:16
 */
@Component
public enum EnumRole {
    
    ADMINISTRATOR("Administrator"), ASSO_MEMBER("Association member"), CONSUMER("Consumer");
    
    EnumRole(String role) {
    }
    
}
