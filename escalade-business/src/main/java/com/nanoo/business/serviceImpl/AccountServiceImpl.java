package com.nanoo.business.serviceImpl;

import com.nanoo.business.serviceContract.AccountService;
import com.nanoo.consumer.repository.AccountRepository;
import com.nanoo.model.DTO.AccountDTO;
import com.nanoo.model.entities.Account;
import com.nanoo.model.enums.EnumRole;
import com.nanoo.model.mapper.AccountMapper;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nanoo
 * @create 11/09/2019 - 17:36
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    
    private static final String FORMAT_DATE = "dd/MM/yyyy HH:mm:ss";
    private static final String ENCRYPTION_ALGO = "SHA-256";
    
    private static final String MAIL_FIELD = "mail";
    private static final String PASSWORD_FIELD = "password";
    
    private String result;
    private Map<String,String> errors;
    
    @Override
    public String getResult() { return result; }
    @Override
    public Map<String, String> getErrors() { return errors; }
    
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountMapper accountMapper;
    
    /**
     * TODO
     * @param accountDTO
     * @return
     */
    @Override
    public void saveAccountTestMVC(AccountDTO accountDTO){
        result = "";
        
        Account account = accountMapper.fromDtoToAccount(accountDTO);
        account.setTitle(processTitle(account.getTitle()));
        account.setRoleName(EnumRole.USER); // role is set USER by default.
        account.setPassword(encryptPassword(account.getPassword()));
        account.setDateOfCreation(getCurrentDateTime());
        account.setDateOfUpdate(account.getDateOfCreation());
    
        accountRepository.save(account);
        result = "L'inscription est un succés !";
        
    }
    
    /**
     * This method get Http request, take parameters values of it and call some methods for data process.
     * Then call the consumer layer to check if the user is registered
     * @param accountDTO TODO
     * @return true if the user is registered
     */
    @Override
    public AccountDTO searchRegisteredAccount(AccountDTO accountDTO){
        result = "";
        errors = new HashMap<>();
        
        Account fullAccount = accountRepository.findFirstByMail(accountDTO.getMail());
        
        if (fullAccount == null) {
            setError(MAIL_FIELD, "Aucun compte ne correspond à votre adresse mail");
            return accountDTO;
        }else if (!checkPassword(accountDTO.getPassword(), fullAccount.getPassword())) {
            setError(PASSWORD_FIELD, "Le mot de passe renseigné n'est pas correct");
            return accountDTO;
        }else{
            result = "Vous êtes connecté !";
            return accountMapper.fromAccountToDto(fullAccount);
        }
    }
    
    /**
     * TODO
     * @param title
     * @return
     */
    private String processTitle(String title) {
        if(title.equalsIgnoreCase("Civil"))
            return "N/C";
        else
            return title;
        
    }
    
    /**
     * This method return the current date and time
     * @return current date and time in a String
     */
    private String getCurrentDateTime() {
        DateTime date = new DateTime();
        DateTimeFormatter formatter = DateTimeFormat.forPattern( FORMAT_DATE );
        return date.toString( formatter );
    }
    
    /**
     * This method check if there is a valid confirmed password
     *
     * @param password user password
     * @param confirmation pasword confirmation
     */
    private void passwordValidation(String password, String confirmation) {
        if (password != null && confirmation != null) {
            if (!password.equals(confirmation))
                setError(PASSWORD_FIELD,"Le mot de passe renseigné et sa confirmation ne sont pas les mêmes.");
            /*else if (!password.matches("^[a-zA-Z0-9]{6}")) TODO = style validation doesn't work */
            else if (password.length() > 6 )
                setError(PASSWORD_FIELD,"Le mot de passe doit contenir au minimum 6 caractères");
        } else {
            setError(PASSWORD_FIELD,"Merci de renseigner un mot de passe et le confirmer.");
        }
    }
    
    /**
     * using Jasypt library tu encrypt password effectively.
     * I choose SHA-256 algorithm here, with by default a random salt
     * and a huge iteration number of the hash method.
     * @param password String to encrypt
     * @return The string returned is lenght 56 and contains the hash is base64.
     */
    private String encryptPassword(String password) {
        ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
        passwordEncryptor.setAlgorithm(ENCRYPTION_ALGO);
        passwordEncryptor.setPlainDigest( false );
        return passwordEncryptor.encryptPassword(password);
    }
    
    /**
     * TODO
     * @param plainPassword
     * @param encryptedPassword
     * @return
     */
    private boolean checkPassword(String plainPassword, String encryptedPassword) {
        ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
        passwordEncryptor.setAlgorithm(ENCRYPTION_ALGO);
        passwordEncryptor.setPlainDigest( false );
        return passwordEncryptor.checkPassword(plainPassword,encryptedPassword);
    }
    
    /**
     * This method check if the mail address format is good and not in the DataBase yet.
     * @param mail user mail address
     */
    private void mailValidation(String mail) {
        if ( mail != null ) {
            if ( !mail.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                setError(MAIL_FIELD,"Merci de saisir une adresse mail valide.");
            } else if ( !accountRepository.findByMail(mail).isEmpty() ) {
                setError(MAIL_FIELD,"Cette adresse email appartient déjà à un compte");
            }
        } else {
            setError(MAIL_FIELD,"Merci de saisir une adresse mail.");
        }
    }
    
    /**
     * save errors in a Map
     * @param champ field to treat
     * @param message error message associated to field name
     */
    private void setError(String champ, String message){
        errors.put(champ,message);
    }
}
