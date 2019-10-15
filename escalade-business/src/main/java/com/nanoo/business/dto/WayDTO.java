package com.nanoo.business.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author nanoo
 * @create 24/09/2019 - 10:20
 */
@Data
@NoArgsConstructor
public class WayDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /* Required */
    @NotNull(message = "Ce champ est requis")
    @Max(30)
    private String name;
    @NotNull(message = "Ce champ est requis")
    private String rating;
    @Min(value = 1, message = "La hauteur doit être renseignée")
    private int height;
    
    private Integer id; // Auto-generated
    private Integer idAccount; // Auto-set
    private Integer idSector; // Auto-set
    private int ratingLevel; // Auto-set
    private String dateOfCreation; // Auto-set
    private String dateOfUpdate; // Auto-set
    
    /* Not required */
    private String description;
    private int pitchNbr;
    private int anchorNbr;
}
