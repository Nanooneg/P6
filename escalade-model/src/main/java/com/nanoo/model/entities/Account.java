package com.nanoo.model.entities;

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
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String mail;
    @Embedded
    private Address address;
    @Enumerated(EnumType.STRING)
    @Column(name = "role_name", length = 6, nullable = false)
    private EnumRole roleName;
    @Column(length = 56,nullable = false)
    private String password;
    @Column(name = "date_of_creation", nullable = false)
    private String dateOfCreation;
    @Column(name = "date_of_update")
    private String dateOfUpdate;
    
}
