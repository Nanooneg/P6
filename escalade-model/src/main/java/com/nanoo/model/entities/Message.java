package com.nanoo.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:17
 */
@Entity
@Data
@NoArgsConstructor
public class Message implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "id_account")
    private Integer idAccount;
    @Column(name = "id_topo_booking")
    private Integer idTopoBooking;
    private DateTime date;
    private String text;
    
}
