package com.nanoo.model.entities.publication;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author nanoo
 * @create 02/09/2019 - 15:34
 */
@Entity
@Data @NoArgsConstructor
/*@Cacheable @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)*/
public class Publication implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "id_account")
    private Integer idAccount;
    private String name;
    private String description;
    @Column(name = "date_of_creation")
    private DateTime dateOfCreation;
    @Column(name = "date_of_update")
    private DateTime dateOfUpdate;
    
}
