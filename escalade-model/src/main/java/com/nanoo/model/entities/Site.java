package com.nanoo.model.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:20
 */
@Entity
@Data @NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Site extends Publication{
    
    @Column(name = "id_topo")
    private Integer idTopo;
    private String region;
    private String location;
    @Column(name = "is_official_label")
    private boolean isOfficialLabel;
    
}
