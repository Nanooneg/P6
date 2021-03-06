package com.nanoo.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:20
 */
@Entity
@Getter @Setter
@NoArgsConstructor
@SequenceGenerator(name = "seq_publication",sequenceName = "seq_way", initialValue = 2000)
public class Way extends Publication{
    
    @ManyToOne(fetch = FetchType.LAZY)
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
    
}
