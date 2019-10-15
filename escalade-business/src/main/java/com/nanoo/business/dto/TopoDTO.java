package com.nanoo.business.dto;

import com.nanoo.business.customValidation.ValidImage;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @author nanoo
 * @create 14/10/2019 - 10:22
 */
@Data
@NoArgsConstructor
public class TopoDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /* Required */
    @NotNull(message = "Ce champ est requis")
    @Size(max = 30, message = "30 caractères maximum")
    private String name;
    @NotNull(message = "Ce champ est requis")
    @Size(min = 10,max = 300,message = "10 caractères minimum, 300 maximum")
    private String description;
    @NotNull(message = "Ce champ est requis")
    private String region;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfPublication;
    @NotNull(message = "Ce champ est requis")
    private String condition;
    private boolean lendable;
    
    private Integer id; // Auto-generated
    private Integer idAccount; // Auto-set
    private String dateOfCreation; // Auto-set
    private String dateOfUpdate; // Auto-set
    
    /* Not required */
    private String picturePath;
    @ValidImage(message = "Ce type d'image n'est pas pris en charge")
    private MultipartFile picture;
    
}
