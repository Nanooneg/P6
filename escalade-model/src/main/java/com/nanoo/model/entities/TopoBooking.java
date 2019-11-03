package com.nanoo.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:17
 */
@Entity
@Data
@NoArgsConstructor
public class TopoBooking implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "id_account_borrower", nullable = false)
    private Integer idAccountBorrower;
    @Column(name = "id_account_owner", nullable = false)
    private Integer idAccountOwner;
    @Column(name = "id_topo", nullable = false)
    private Integer idTopo;
    @Column(name = "status", length = 10, nullable = false)
    private String status;
    @Column(name = "owner_mail", length = 30)
    private String ownerMail;
    @Column(name = "date_of_creation",length = 30, nullable = false)
    private Date dateOfCreation;
    @Column(name = "date_of_update",length = 30, nullable = false)
    private Date dateOfUpdate;
    @Column(name = "date_of_expiry",length = 30, nullable = false)
    private Date dateOfExpiry;
    
}
