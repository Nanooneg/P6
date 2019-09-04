package com.nanoo.model.entities.publication;

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
public class TopoBooking implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @Column(name = "id_account")
    private Integer idAccount;
    @Column(name = "id_topo")
    private Integer idTopo;
    @Column(name = "date_of_begin")
    private DateTime dateOfBegin;
    @Column(name = "date_of_end")
    private DateTime dateOfEnd;
    
}
