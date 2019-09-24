package com.nanoo.business.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author nanoo
 * @create 24/09/2019 - 09:59
 */
@Data
@NoArgsConstructor
public class SiteDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /* Publication attributes */
    private Integer id;
    private Integer idAccount;
    private String name;
    private String description;
    private String dateOfCreation;
    private String dateOfUpdate;
    
    /* Site attributes */
    private Integer idTopo;
    private String region;
    private String location;
    private boolean officialLabel;
    
}
