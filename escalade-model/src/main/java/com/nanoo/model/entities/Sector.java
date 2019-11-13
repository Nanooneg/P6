package com.nanoo.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:20
 */
@Entity
@Getter @Setter
@NoArgsConstructor
@SequenceGenerator(name = "seq_publication",sequenceName = "seq_sector", initialValue = 1000)
public class Sector extends Publication {
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_site", nullable = false)
    private Site site;
    @OneToMany(mappedBy = "sector", orphanRemoval = true, cascade = CascadeType.REMOVE)
    private Set<Way> ways;
    
}
