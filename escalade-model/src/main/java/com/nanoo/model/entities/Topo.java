package com.nanoo.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:17
 */
@Entity
@Data @NoArgsConstructor
public class Topo implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "id_account", nullable = false)
    private Integer idAccount;
    @Column(nullable = false)
    private String region;
    @Column(name = "date_of_publication", nullable = false)
    private DateTime dateOfPublication;
    @Column(name = "is_lendable")
    private boolean isLendable;
    
}
