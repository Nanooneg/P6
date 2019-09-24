package com.nanoo.business.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author nanoo
 * @create 24/09/2019 - 10:08
 */
@Data
@NoArgsConstructor
public class SectorDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /* Publication attributes */
    private Integer id;
    private Integer idAccount;
    private String name;
    private String description;
    private String dateOfCreation;
    private String dateOfUpdate;
    
    /* Sector attributes */
    private Integer idSite;
    
}
