package com.nanoo.model.DTO;

import lombok.NoArgsConstructor;

/**
 * @author nanoo
 * @create 14/09/2019 - 14:43
 */
@NoArgsConstructor
public class AccountDTO {

    private Integer id;
    private String title;
    private String lastName;
    private String firstName;
    private String mail;
    private String roleName;
    private String password;
    private String confirmation;
    private String dateOfCreation;
    private String dateOfUpdate;
    private String streetName;
    private int postalCode;
    private String city;
    
    
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
    
    public String getRoleName() {
        return roleName;
    }
    
    public void setRoleName(String roleName) {
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
