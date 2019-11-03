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
public class Sector extends Publication {
    
    @ManyToOne
    @JoinColumn(name = "id_site", nullable = false)
    private Site site;
    @OneToMany(mappedBy = "sector", orphanRemoval = true, cascade = CascadeType.REMOVE)
    private Set<Way> ways;
    
}
