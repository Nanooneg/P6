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
public class Way extends Publication {
    
    @Column(name = "id_sector", nullable = false)
    private Integer idSector;
    @Column(length = 20, nullable = false)
    private String rating;
    @Column(name = "pitch_nbr")
    private int pitchNbr;
    @Column(name = "anchor_nbr")
    private int anchorNbr;
    
}
