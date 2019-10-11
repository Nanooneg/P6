package com.nanoo.business.customValidation;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author nanoo
 * @create 08/10/2019 - 12:01
 */
public class ImageFileValidator implements ConstraintValidator<ValidImage, MultipartFile> {
    
    /**
     * Initializes the validator in preparation for
     * {@link #isValid(MultipartFile, ConstraintValidatorContext)} calls.
     * The constraint annotation for a given constraint declaration
     * is passed.
     * <p>
     * This method is guaranteed to be called before any use of this instance for
     * validation.
     * <p>
     * The default implementation is a no-op.
     *
     * @param constraintAnnotation annotation instance for a given constraint declaration
     */
    @Override
    public void initialize(ValidImage constraintAnnotation) {
        constraintAnnotation.message();
    }
    
    /**
     * Implements the validation logic. Get contentType from {@code multipartFile} and use
     * {@link #isSupportedContentType(String)} to compare with authorized list.
     *
     * @param multipartFile object to validate
     * @param context context in which the constraint is evaluated
     * @return {@code false} if {@code multipartFile} does not pass the constraint
     */
    @Override
    public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext context) {
        
        String contentType = multipartFile.getContentType();
        if (contentType != null) {
            return isSupportedContentType(contentType);
        }else return true;
        
    }
    
    /**
     * Compare {@code contentType} with authorized values.
     *
     * @param contentType String to validate
     * @return {@code false} if {@code contentType} does not pass the constraint
     */
    private boolean isSupportedContentType(String contentType) {
        
        return contentType.equals("image/png")
                || contentType.equals("image/jpeg")
                || contentType.equals("application/octet-stream");
    }
}
