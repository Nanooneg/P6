package com.nanoo.business.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author nanoo
 * @create 16/10/2019 - 13:58
 */
@Data
@NoArgsConstructor
public class TopoBookingDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private Integer idAccountBorrower;
    private Integer idTopo;
    private String status;
    private String ownerMail;
    private Date dateOfCreation;
    private Date dateOfUpdate;
    private Date dateOfExpiry;
    
}
