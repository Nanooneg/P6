package com.nanoo.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author nanoo
 * @create 02/09/2019 - 15:34
 */
@MappedSuperclass
@Data @NoArgsConstructor
public class Publication implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "id_account", nullable = false)
    private Integer idAccount;
    @Column(nullable = false)
    private String name;
    @Column(length = 300)
    private String description;
    @Column(name = "date_of_creation",length = 30, nullable = false)
    private Date dateOfCreation;
    @Column(name = "date_of_update",length = 30, nullable = false)
    private Date dateOfUpdate;
    
}
