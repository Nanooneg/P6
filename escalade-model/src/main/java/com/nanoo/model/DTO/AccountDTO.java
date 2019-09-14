package com.nanoo.model.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nanoo
 * @create 14/09/2019 - 14:43
 */
@Data @NoArgsConstructor
public class AccountDTO {

    private Integer id;
    private String title;
    private String lastName;
    private String firstName;
    private String mail;
    private String roleName;
    private String password;
    private String confirmation;
    private String dateOfCreation;
    private String dateOfUpdate;
    private String streetName;
    private int postalCode;
    private String city;
    
}
