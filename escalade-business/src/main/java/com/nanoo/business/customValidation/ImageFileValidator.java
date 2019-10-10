package com.nanoo.business.customValidation;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author nanoo
 * @create 08/10/2019 - 12:01
 */
public class ImageFileValidator implements ConstraintValidator<ValidImage, MultipartFile> {
    
    @Override
    public void initialize(ValidImage constraintAnnotation) {
        constraintAnnotation.message();
    }
    
    @Override
    public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext context) {
        
        String contentType = multipartFile.getContentType();
        if (contentType != null) {
            return isSupportedContentType(contentType);
        }else return true;
        
    }
    
    private boolean isSupportedContentType(String contentType) {
        
        return contentType.equals("image/png")
                || contentType.equals("image/jpeg")
                || contentType.equals("application/octet-stream");
    }
}
