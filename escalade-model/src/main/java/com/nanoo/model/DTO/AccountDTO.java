package com.nanoo.model.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author nanoo
 * @create 14/09/2019 - 14:43
 */
@Data
@NoArgsConstructor
public class AccountDTO {
    
    /* Required */
    @NotNull(message = "Ce champ est requis")
    private String title;
    @NotNull(message = "Ce champ est requis")
    private String lastName;
    @NotNull(message = "Ce champ est requis")
    private String firstName;
    @Email(message = "Veuillez renseigner une adresse mail valide")
    @NotNull(message = "Ce champ est requis")
    private String mail;
    private String roleName; // Set by default (USER)
    @NotNull(message = "Ce champ est requis")
    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})",
            message = "6 caractères minimum (1 majuscule 1 chiffre et 1 symbole (@#$%)")
    private String password;
    @NotNull(message = "Vous devez confirmer votre mot de passe")
    //@IsConfirmationOk
    private String confirmation;
    
    private Integer id; // Auto-generated
    private String dateOfCreation; // Auto-set
    private String dateOfUpdate; // Auto-set
    
    /* Not required */
    private String streetName;
    @Pattern(regexp = "^[0-9]{5}", message = "Veuillez renseigner un code postal valide")
    private String postalCode;
    private String city;
    
}
