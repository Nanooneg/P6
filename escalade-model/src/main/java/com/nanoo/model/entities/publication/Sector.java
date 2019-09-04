package com.nanoo.model.entities.publication;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:20
 */
@Entity
@Data @NoArgsConstructor
public class Sector extends Publication implements Serializable {
    
    @Id
    private Integer id;
    @Column(name = "id_site")
    private Integer idSite;
    
}
