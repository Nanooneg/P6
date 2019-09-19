package com.nanoo.business.customValidation;

import com.nanoo.consumer.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author nanoo
 * @create 19/09/2019 - 11:37
 */
public class AvailableValidator implements ConstraintValidator<IsAvailable,String> {
    
    @Autowired
    AccountRepository accountRepository;
    
    /**
     * Initializes the validator in preparation for
     * {@link #isValid(String, ConstraintValidatorContext)} calls.
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
    public void initialize(IsAvailable constraintAnnotation) {
        constraintAnnotation.message();
    }
    
    /**
     * Implements the validation logic.
     * The state of {@code value} must not be altered.
     * <p>
     * This method can be accessed concurrently, thread-safety must be ensured
     * by the implementation.
     *
     * @param mail   object to validate
     * @param context context in which the constraint is evaluated
     *
     * @return {@code false} if {@code value} does not pass the constraint
     */
    @Override
    public boolean isValid(String mail, ConstraintValidatorContext context) {
        return accountRepository.findFirstByMail(mail) == null;
    }
}
