package com.nanoo.business.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author nanoo
 * @create 03/10/2019 - 22:01
 */
@Data
@NoArgsConstructor
public class CommentaryDTO implements Serializable {
    
    @NotNull(message = "Ce champ est requis")
    @Size(max = 30)
    private String title;
    @NotNull(message = "Ce champ est requis")
    @Size(max = 300)
    private String text;
    
    private Integer id;
    private Integer idAccount;
    private Integer idTypeOfComment;
    private String dateOfPublication;
    private String dateOfModification;
    
}
