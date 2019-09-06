package com.nanoo.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

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
    @Enumerated(EnumType.STRING)
    @Column(length = 4)
    private EnumTitle title;
    private String lastName;
    private String firstName;
    private String mail;
    private Address address;
    /*@Column(name = "id_address")
    private Integer idAddress;*/
    @Enumerated(EnumType.STRING)
    @Column(name = "role_name", length = 6)
    private EnumRole roleName;
    private String login;
    private String password;
    @Column(name = "date_of_creation")
    private DateTime dateOfCreation;
    @Column(name = "date_of_update")
    private DateTime dateOfUpdate;
    
}
