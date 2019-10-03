package com.nanoo.model.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:20
 */
@Entity
@Data @NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Site extends Publication implements Serializable {
    
    @Column(name = "id_topo")
    private Integer idTopo;
    @Column(length = 30, nullable = false)
    private String region;
    @Column(name = "is_official_label", nullable = false)
    private boolean officialLabel;
    @OneToMany(mappedBy = "site")
    private Set<Sector> sectors;
    
}
