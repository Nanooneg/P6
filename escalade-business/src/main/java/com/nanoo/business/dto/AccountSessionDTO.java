package com.nanoo.business.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author nanoo
 * @create 18/10/2019 - 16:51
 */
@Getter @Setter
@NoArgsConstructor
public class AccountSessionDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String roleName;
    private String title;
    private String lastName;
    private String firstName;
    private String mail;
    
}