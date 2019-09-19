package com.nanoo.business.customValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author nanoo
 * @create 19/09/2019 - 11:36
 */
@Documented
@Target({ FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = { AvailableValidator.class })
public @interface IsAvailable {
    
    String message() default "n'est pas disponible";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    
}
