package com.nanoo.consumer.entities.user;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:01
 */
public class Account implements Serializable {
    
    private Long id;
    private String title;
    private String lastName;
    private String firstName;
    private String mail;
    private Adress adress;
    private EnumRole role;
    private String login;
    private String password;
    private DateTime dateOfCreate;
    private DateTime dateOfUpdate;
    
    public Account() {
        super();
    }
    
    public Account(Long id, String title, String lastName, String firstName, String mail,Adress adress,EnumRole role, String login, String password, DateTime dateOfCreate, DateTime dateOfUpdate) {
        this.id = id;
        this.title = title;
        this.lastName = lastName;
        this.firstName = firstName;
        this.mail = mail;
        this.adress= adress;
        this.role = role;
        this.login = login;
        this.password = password;
        this.dateOfCreate = dateOfCreate;
        this.dateOfUpdate = dateOfUpdate;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(long id) {
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
    
    public Adress getAdress() {
        return adress;
    }
    
    public void setAdress(Adress adress) {
        this.adress = adress;
    }
    
    public EnumRole getRole() {
        return role;
    }
    
    public void setRole(EnumRole role) {
        this.role = role;
    }
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public DateTime getDateOfCreate() {
        return dateOfCreate;
    }
    
    public void setDateOfCreate(DateTime dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }
    
    public DateTime getDateOfUpdate() {
        return dateOfUpdate;
    }
    
    public void setDateOfUpdate(DateTime dateOfUpdate) {
        this.dateOfUpdate = dateOfUpdate;
    }
}
