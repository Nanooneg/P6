package com.nanoo.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:17
 */
@Entity
@Data @NoArgsConstructor
public class Topo extends Publication implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String region;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_publication", length = 30, nullable = false)
    private Date dateOfPublication;
    @Column(name = "is_lendable", nullable = false)
    private boolean lendable;
    @Column(length = 10, nullable = false)
    private String condition;
    @Column(name = "picture_path")
    private String picturePath;
    
    
    @Transient
    private MultipartFile picture;
    
}
