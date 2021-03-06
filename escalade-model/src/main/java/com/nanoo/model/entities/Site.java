package com.nanoo.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:20
 */
@Entity
@Getter @Setter
@NoArgsConstructor
@SequenceGenerator(name = "seq_publication",sequenceName = "seq_site", initialValue = 100)
public class Site extends Publication implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Column(length = 30, nullable = false)
    private String region;
    @Column(name = "is_official_label", nullable = false)
    private boolean officialLabel;
    @OneToMany(mappedBy = "site", orphanRemoval = true, cascade = CascadeType.REMOVE)
    private Set<Sector> sectors;
    @Column(name = "picture_path")
    private String picturePath;
    
    @Transient
    private MultipartFile picture;
    
}
