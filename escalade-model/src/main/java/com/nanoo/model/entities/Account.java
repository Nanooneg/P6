package com.nanoo.model.entities;

import com.nanoo.model.enums.EnumRole;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:01
 */
@Entity
@Data @NoArgsConstructor
public class Account implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    /* Required */
    @Column(length = 4, nullable = false)
    private String title;
    @Column(length = 30, nullable = false)
    private String lastName;
    @Column(length = 30, nullable = false)
    private String firstName;
    @Column(length = 30, unique = true,nullable = false)
    private String mail;
    @Enumerated(EnumType.STRING)
    @Column(name = "role_name", length = 6, nullable = false)
    private EnumRole roleName;
    @Column(length = 56, nullable = false)
    private String password;
    @Transient
    private String confirmation;
    @Column(name = "date_of_creation",length = 30, nullable = false)
    private String dateOfCreation;
    @Column(name = "date_of_update",length = 30, nullable = false)
    private String dateOfUpdate;
    
    /* Not required */
    @Column(name = "street_name", length = 30)
    private String streetName;
    @Column(name = "postal_code")
    private int postalCode;
    @Column(length = 30)
    private String city;
    
}
