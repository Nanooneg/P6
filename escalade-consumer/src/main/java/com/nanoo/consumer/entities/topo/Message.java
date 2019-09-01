package com.nanoo.consumer.entities.topo;

import org.joda.time.DateTime;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:17
 */
public class Message {

    private Long id;
    private DateTime date;
    private String text;
    private Long idAccount;
    private Long idTopoBooking;
    
    public Message() {
    }
    
    public Message(Long id, DateTime date, String text, Long idAccount, Long idTopoBooking) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.idAccount = idAccount;
        this.idTopoBooking = idTopoBooking;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public DateTime getDate() {
        return date;
    }
    
    public void setDate(DateTime date) {
        this.date = date;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public Long getIdAccount() {
        return idAccount;
    }
    
    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }
    
    public Long getIdTopoBooking() {
        return idTopoBooking;
    }
    
    public void setIdTopoBooking(Long idTopoBooking) {
        this.idTopoBooking = idTopoBooking;
    }
}
