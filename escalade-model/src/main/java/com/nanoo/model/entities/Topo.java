package com.nanoo.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:17
 */
@Entity
@Data @NoArgsConstructor
@Cacheable @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Topo implements Serializable {
    
    @Id
    private Integer id;
    private String region;
    @Column(name = "date_of_publication")
    private DateTime dateOfPublication;
    @Column(name = "is_lendable")
    private boolean isLendable;
    
}
