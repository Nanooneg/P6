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
 * @create 18/09/2019 - 18:23
 */
@Documented
@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = { FieldsEqualityValidator.class })
public @interface FieldsEquality {
    
    String message() default "{FieldsEquality.message}";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
    
    /**
     * Name of the first field that will be compared.
     *
     * @return name
     */
    String firstFieldName();
    
    /**
     * Name of the second field that will be compared.
     *
     * @return name
     */
    String secondFieldName();
    
    @Target({ TYPE, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    public @interface List {
        FieldsEquality[] value();
    }
}
