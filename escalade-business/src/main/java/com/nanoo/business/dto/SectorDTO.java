package com.nanoo.business.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @author nanoo
 * @create 24/09/2019 - 10:08
 */
@Data
@NoArgsConstructor
public class SectorDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /* Required */
    @NotNull(message = "Ce champ est requis")
    @Size(max = 30, message = "30 caractères maximum")
    private String name;
    @NotNull(message = "Ce champ est requis")
    @Size(min = 10,max = 300,message = "10 caractères minimum, 300 maximum")
    private String description;
    
    private Integer id; // Auto-generated
    private Integer idSite; // Auto-set
    private Integer idAccount; // Auto-set
    private Date dateOfCreation; // Auto-set
    private Date dateOfUpdate; // Auto-set
    
}
