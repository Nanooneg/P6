package com.nanoo.model.entities.publication;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.beans.ConstructorProperties;
import java.io.Serializable;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:20
 */
@Entity
@Data @NoArgsConstructor
public class Site extends Publication implements Serializable{

    @Id
    private Integer id;
    @Column(name = "id_topo")
    private Integer idTopo;
    private String region;
    private String location;
    @Column(name = "is_official_label")
    private boolean isOfficialLabel;
    
}
