package com.nanoo.business.customValidation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

/**
 * @author nanoo
 * @create 18/09/2019 - 18:26
 */
public class FieldsEqualityValidator implements ConstraintValidator<FieldsEquality, Object> {
   private static final Logger log = LoggerFactory.getLogger(FieldsEqualityValidator.class);
   
   private String firstFieldName;
   private String secondFieldName;
   
   @Override
   public void initialize(FieldsEquality constraintAnnotation) {
      firstFieldName = constraintAnnotation.firstFieldName();
      secondFieldName = constraintAnnotation.secondFieldName();
   }
   
   @Override
   public boolean isValid(Object value, ConstraintValidatorContext context) {
      if (value == null)
         return true;
      
      try {
         Class<?> clazz = value.getClass();
         
         Field firstField = ReflectionUtils.findField(clazz, firstFieldName);
         firstField.setAccessible(true);
         Object first = firstField.get(value);
         
         Field secondField = ReflectionUtils.findField(clazz, secondFieldName);
         secondField.setAccessible(true);
         Object second = secondField.get(value);
         
         if (first != null && second != null && !first.equals(second)) {
            
            ConstraintValidatorContext.ConstraintViolationBuilder cvb = context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate());
            cvb.addNode(secondFieldName).addConstraintViolation();
   
            return false;
         }
      } catch (Exception e) {
         log.error("Cannot validate fileds equality in '" + value + "'!", e);
         return false;
      }
      
      return true;
   }
   
}
