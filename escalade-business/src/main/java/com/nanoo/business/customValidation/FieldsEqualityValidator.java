package com.nanoo.business.customValidation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.util.Objects;

/**
 * @author nanoo
 * @create 18/09/2019 - 18:26
 */
public class FieldsEqualityValidator implements ConstraintValidator<FieldsEquality, Object> {
   
   private static final Logger log = LoggerFactory.getLogger(FieldsEqualityValidator.class);
   
   private String firstFieldName;
   private String secondFieldName;
   
   /**
    * Initializes the validator in preparation for
    * {@link #isValid(Object, ConstraintValidatorContext)} calls.
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
   public void initialize(FieldsEquality constraintAnnotation) {
      constraintAnnotation.message();
      firstFieldName = constraintAnnotation.firstFieldName();
      secondFieldName = constraintAnnotation.secondFieldName();
   }
   
   /**
    * Implements the validation logic.
    * Check equality of two field.
    *
    * @param value object to get fields to compare
    * @param context context in which the constraint is evaluated
    * @return {@code false} if fields are not equal
    */
   @Override
   public boolean isValid(Object value, ConstraintValidatorContext context) {
      if (value == null)
         return true;
      
      try {
         Class<?> clazz = value.getClass();
         
         Field firstField = ReflectionUtils.findField(clazz, firstFieldName);
         Objects.requireNonNull(firstField).setAccessible(true);
         Object first = firstField.get(value);
         
         Field secondField = ReflectionUtils.findField(clazz, secondFieldName);
         Objects.requireNonNull(secondField).setAccessible(true);
         Object second = secondField.get(value);
         
         if (first != null && second != null && !first.equals(second)) {
            
            ConstraintValidatorContext.ConstraintViolationBuilder cvb =
                    context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate());
            cvb.addNode(secondFieldName).addConstraintViolation();
   
            return false;
         }
      } catch (Exception e) {
         log.error("Cannot validate fields equality in '" + value + "'!", e);
         return false;
      }
      
      return true;
   }
   
}
