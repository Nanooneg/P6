package com.nanoo.model.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.Set;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:20
 */
@Entity
@Data @NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Site extends Publication {
    
    @Column(length = 30, nullable = false)
    private String region;
    @Column(name = "is_official_label", nullable = false)
    private boolean officialLabel;
    @OneToMany(mappedBy = "site")
    private Set<Sector> sectors;
    @Column(name = "picture_path")
    private String picturePath;
    
    
    @Transient
    private MultipartFile picture;
    
}
