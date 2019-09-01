package com.nanoo.consumer.entities.topo;

import org.joda.time.DateTime;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:17
 */
public class TopoBooking {

    private Long Id;
    private DateTime dateOfBegin;
    private DateTime dateOfEnd;
    private Long idAccount;
    private Long idTopo;
    
    public TopoBooking() {
    }
    
    public TopoBooking(Long id, DateTime dateOfBegin, DateTime dateOfEnd, Long idAccount, Long idTopo) {
        Id = id;
        this.dateOfBegin = dateOfBegin;
        this.dateOfEnd = dateOfEnd;
        this.idAccount = idAccount;
        this.idTopo = idTopo;
    }
    
    public Long getId() {
        return Id;
    }
    
    public void setId(Long id) {
        Id = id;
    }
    
    public DateTime getDateOfBegin() {
        return dateOfBegin;
    }
    
    public void setDateOfBegin(DateTime dateOfBegin) {
        this.dateOfBegin = dateOfBegin;
    }
    
    public DateTime getDateOfEnd() {
        return dateOfEnd;
    }
    
    public void setDateOfEnd(DateTime dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }
    
    public Long getIdAccount() {
        return idAccount;
    }
    
    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }
    
    public Long getIdTopo() {
        return idTopo;
    }
    
    public void setIdTopo(Long idTopo) {
        this.idTopo = idTopo;
    }
}
