package com.nanoo.business.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

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
    @Size(max = 30, message = "30 caractères maximum")
    private String name;
    @NotNull(message = "Ce champ est requis")
    private String rating;
    @Min(value = 1, message = "La hauteur doit être renseignée")
    private int height;
    
    private Integer id; // Auto-generated
    private Integer idAccount; // Auto-set
    private Integer idSector; // Auto-set
    private int ratingLevel; // Auto-set
    private Date dateOfCreation; // Auto-set
    private Date dateOfUpdate; // Auto-set
    
    /* Not required */
    private String description;
    private int pitchNbr;
    private int anchorNbr;
}
