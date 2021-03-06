package com.nanoo.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:01
 */
@Entity
@Getter @Setter
@NoArgsConstructor
@SequenceGenerator(name = "seq_account", initialValue = 10)
public class Account implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_account")
    private Integer id;
    
    /* Required */
    @Column(length = 4, nullable = false)
    private String title;
    @Column(length = 30, nullable = false)
    private String lastName;
    @Column(length = 30, nullable = false)
    private String firstName;
    @Column(length = 30, unique = true, nullable = false)
    private String mail;
    @Column(name = "role_name", length = 13, nullable = false)
    private String roleName;
    @Column(length = 56, nullable = false)
    private String password;
    @Transient
    private String confirmation;
    @Column(name = "date_of_creation",length = 30, nullable = false)
    private Date dateOfCreation;
    @Column(name = "date_of_update",length = 30, nullable = false)
    private Date dateOfUpdate;
    
    /* Not required */
    @Column(name = "street_name", length = 30)
    private String streetName;
    @Column(name = "postal_code")
    private int postalCode;
    @Column(length = 30)
    private String city;
    
}
