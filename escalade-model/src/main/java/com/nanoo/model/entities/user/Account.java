package com.nanoo.model.entities.user;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String lastName;
    private String firstName;
    private String mail;
    @Column(name = "id_address")
    private Integer idAddress;
    @Column(name = "role_name")
    private String roleName;
    private String login;
    private String password;
    @Column(name = "date_of_creation")
    private DateTime dateOfCreation;
    @Column(name = "date_of_update")
    private DateTime dateOfUpdate;
    
}
