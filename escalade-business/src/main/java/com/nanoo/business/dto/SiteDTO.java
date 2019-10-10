package com.nanoo.business.dto;

import com.nanoo.business.customValidation.ValidImage;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author nanoo
 * @create 24/09/2019 - 09:59
 */
@Data
@NoArgsConstructor
public class SiteDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    //* Required */
    @NotNull(message = "Ce champ est requis")
    private String name;
    @NotNull(message = "Ce champ est requis")
    @Size(min = 10,max = 300,message = "10 caractères minimum, 300 maximum")
    private String description;
    @NotNull(message = "Ce champ est requis")
    private String region;
    
    private Integer id; // Auto-generated
    private Integer idAccount; // Auto-set
    private String dateOfCreation; // Auto-set
    private String dateOfUpdate; // Auto-set
    private boolean officialLabel; // Set by default (false)
    
    /* Not required */
    private String picturePath;
    @ValidImage(message = "Ce type d'image n'est pas pris en charge")
    private MultipartFile picture;
    
}
