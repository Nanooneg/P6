package com.nanoo.business.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @author nanoo
 * @create 03/10/2019 - 22:01
 */
@Data
@NoArgsConstructor
public class CommentaryDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /* Required */
    @NotNull(message = "Ce champ est requis")
    @Size(max = 30)
    private String title;
    @NotNull(message = "Ce champ est requis")
    @Size(max = 300)
    private String text;
    
    private Integer id; // Auto-generated
    private Integer idAccount; // Auto-set
    private Integer idPublication; // Auto-set
    private Date dateOfPublication; // Auto-set
    private Date dateOfModification; // Auto-set
    
}
