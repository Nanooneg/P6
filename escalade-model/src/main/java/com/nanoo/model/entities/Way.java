package com.nanoo.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:20
 */
@Entity
@Getter @Setter
@NoArgsConstructor
public class Way extends Publication{
    
    @ManyToOne
    @JoinColumn(name = "id_sector", nullable = false)
    private Sector sector;
    @Column(length = 20, nullable = false)
    private String rating;
    @Column(name = "rating_level", nullable = false)
    private int ratingLevel;
    @Column(nullable = false)
    private int height;
    @Column(name = "pitch_nbr")
    private int pitchNbr;
    @Column(name = "anchor_nbr")
    private int anchorNbr;
    
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
    
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
