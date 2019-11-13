package com.nanoo.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:18
 */
@Entity
@Getter @Setter
@NoArgsConstructor
@SequenceGenerator(name = "seq_commentary", initialValue = 20)
public class Commentary implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_commentary")
    private Integer id;
    
    /* Required */
    @Column(name = "id_account")
    private Integer idAccount;
    @Column(name = "id_type_of_comment")
    private Integer idPublication;
    @Column(length = 30, nullable = false)
    private String title;
    @Column(length = 300, nullable = false)
    private String text;
    @Column(name = "date_of_creation",length = 30, nullable = false)
    private Date dateOfPublication;
    @Column(name = "date_of_update",length = 30, nullable = false)
    private Date dateOfModification;

    
}
