package com.nanoo.business.customValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author nanoo
 * @create 08/10/2019 - 12:00
 */
@Documented
@Target({ FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = { ImageFileValidator.class })
public @interface ValidImage {
    
    String message() default "mauvais format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    
}