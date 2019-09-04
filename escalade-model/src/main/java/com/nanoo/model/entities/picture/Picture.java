package com.nanoo.model.entities.picture;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:20
 */
@Entity
@Data
@NoArgsConstructor
public class Picture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "id_topo")
    private Integer idTopo;
    @Column(name = "id_Site")
    private Integer idSite;
    private String path;
    private String name;

    
}
