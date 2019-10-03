package com.nanoo.model.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Sector extends Publication implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "id_site", nullable = false)
    private Site site;
    @OneToMany(mappedBy = "sector")
    private Set<Way> ways;
    
}
