package com.nanoo.business.dto;

import com.nanoo.business.customValidation.FieldsEquality;
import com.nanoo.business.customValidation.IsAvailable;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * @author nanoo
 * @create 14/09/2019 - 14:43
 */
@Data
@NoArgsConstructor
@FieldsEquality(firstFieldName = "password", secondFieldName = "confirmation",
                message = "Le mot de passe et la confirmation ne sont pas identiques")
public class AccountDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /* Required */
    @NotNull(message = "Ce champ est requis")
    private String title;
    @NotNull(message = "Ce champ est requis")
    private String lastName;
    @NotNull(message = "Ce champ est requis")
    private String firstName;
    @NotNull(message = "Ce champ est requis")
    @IsAvailable(message = "Cette adresse mail est déjà utilisé dans un autre compte")
    @Pattern(regexp = "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)",
            message = "Veuillez renseigner une adresse mail valide")
    private String mail;
    @NotNull(message = "Ce champ est requis")
    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})",
            message = "6 caractères minimum (1 majuscule 1 chiffre et 1 symbole (@#$%)")
    private String password;
    @NotNull(message = "Vous devez confirmer votre mot de passe")
    private String confirmation;
    
    private Integer id; // Auto-generated
    private String roleName; // Set by default (USER)
    private Date dateOfCreation; // Auto-set
    private Date dateOfUpdate; // Auto-set
    
    /* Not required */
    private String streetName;
    @Pattern(regexp = "^[0-9]{5}", message = "Veuillez renseigner un code postal valide")
    private String postalCode;
    private String city;
    
}
