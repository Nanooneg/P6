package com.nanoo.model.entities;

import com.nanoo.model.enums.EnumRole;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:01
 */
@Entity
@NoArgsConstructor
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
    
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getMail() {
        return mail;
    }
    
    public void setMail(String mail) {
        this.mail = mail;
    }
    
    public EnumRole getRoleName() {
        return roleName;
    }
    
    public void setRoleName(EnumRole roleName) {
        this.roleName = roleName;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getConfirmation() {
        return confirmation;
    }
    
    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }
    
    public String getDateOfCreation() {
        return dateOfCreation;
    }
    
    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
    
    public String getDateOfUpdate() {
        return dateOfUpdate;
    }
    
    public void setDateOfUpdate(String dateOfUpdate) {
        this.dateOfUpdate = dateOfUpdate;
    }
    
    public String getStreetName() {
        return streetName;
    }
    
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    
    public int getPostalCode() {
        return postalCode;
    }
    
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
}
