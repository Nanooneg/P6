package com.nanoo.model.entities.publication;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:18
 */
@Entity
@Data @NoArgsConstructor
public class Commentary implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "id_account")
    private Integer idAccount;
    @Column(name = "id_type_of_comment")
    private Integer idTypeOfComment;
    private String title;
    private String text;
    @Column(name = "like_nbr")
    private int likeNbr;
    @Column(name = "dislike_nbr")
    private int dislikeNbr;

    
}
