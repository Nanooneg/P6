package com.nanoo.business.serviceImpl;

import com.nanoo.business.exception.DataValidationException;
import com.nanoo.business.serviceContract.RegistrationService;
import com.nanoo.consumer.repository.AccountRepository;
import com.nanoo.model.entities.Account;
import com.nanoo.model.entities.Address;
import com.nanoo.model.entities.EnumRole;
import lombok.Getter;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author nanoo
 * @create 01/09/2019 - 16:44
 */
@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {
    
    private static final String ENCRYPTION_ALGO = "SHA-256";
    private static final String FORMAT_DATE = "dd/MM/yyyy HH:mm:ss";
    
    private static final String ADDRESS_FIELD = "streetName";
    private static final String POSTAL_CODE_FIELD= "postalCode";
    private static final String CITY_FIELD= "city";
    
    private static final String TITLE_FIELD = "title";
    private static final String FIRST_NAME_FIELD = "firstName";
    private static final String LAST_NAME_FIELD = "lastName";
    private static final String MAIL_FIELD = "mail";
    private static final String USERNAME_FIELD = "username";
    private static final String PASSWORD_FIELD = "password";
    private static final String CONFIRMATION_FIELD = "passwordConf";
    
    @Getter private String result;
    @Getter private Map<String,String> errors;
    
    @Autowired
    private AccountRepository accountRepository;
    
    /**
     * This method get Http request, take parameters values of it and call some methods for data process.
     * Then call the consumer layer to save the Account entity.
     * @param req Http request
     */
    @Override
    public Account saveAccount(HttpServletRequest req){
        String streetName = getFieldsValues(req,ADDRESS_FIELD);
        int postalCode = Integer.parseInt(getFieldsValues(req,POSTAL_CODE_FIELD));
        String city = getFieldsValues(req,CITY_FIELD);
    
        String title = getFieldsValues(req,TITLE_FIELD);
        String firstName = getFieldsValues(req,FIRST_NAME_FIELD);
        String lastName = getFieldsValues(req,LAST_NAME_FIELD);
        String mail = getFieldsValues(req,MAIL_FIELD);
        String username = getFieldsValues(req,USERNAME_FIELD);
        String password = getFieldsValues(req,PASSWORD_FIELD);
        String passwordConf = getFieldsValues(req,CONFIRMATION_FIELD);
    
        Account account = new Account();
        Address address = new Address();
        String currentDT = getCurrentDateTime();
        errors = new HashMap<>();
        
        try{
            
            processAddress(streetName,postalCode,city,address);
            processName(title,firstName,lastName,username,account);
            processMail(mail, account);
            processPassword(password,passwordConf,account);
            
            if (errors.isEmpty()){
                account.setAddress(address);
                account.setRoleName(EnumRole.USER);
                account.setDateOfCreation(currentDT);
                accountRepository.save(account);
                result = "L'inscription est un succés !";
            }else {
                result = "Échec de l'inscription...";
            }
        } catch (DataValidationException e) {
            result = "Échec de l'inscription : une erreur imprévue est survenue, ne décourage pas et réessaie dans quelques instants.";
            e.printStackTrace();
        }
        
        return account;
    }
    
    /**
     * This method get Http request, take parameters values of it and call some methods for data process.
     * Then call the consumer layer to check if the user is registered
     * @param req Http request
     * @return true if the user is registered
     */
    @Override
    public Account searchRegisteredAccount(HttpServletRequest req){
        String mail = getFieldsValues(req,MAIL_FIELD);
        String password = getFieldsValues(req,PASSWORD_FIELD);
        String encryptPassword = encryptPassword(password);
        errors = new HashMap<>();
        
        Account account = accountRepository.searchForLoginRequest(mail,encryptPassword);
        System.out.println(account);
        
        if (account == null) {
            setError(MAIL_FIELD, "Votre mail et/ou votre mot de passe ne sont pas bon(s)");
            setError(PASSWORD_FIELD, "Votre mail et/ou votre mot de passe ne sont pas bon(s)");
        }
    
        return account;
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
     * Get the value from the Http request and return null if there is nothing to save
     * @param req Http request
     * @param field field name to treat
     */
    private String getFieldsValues(HttpServletRequest req, String field){
        String value = req.getParameter(field);
        if (value == null || value.trim().length() == 0)
            return null;
        else
            return value;
    }
    
    /**
     * save errors in a Map
     * @param champ field to treat
     * @param message error message associated to field name
     */
    private void setError(String champ, String message){
        errors.put(champ,message);
    }
    
    /**
     * This method call for validation method and then initialize the properties of the entity
     * @param streetName name of the street
     * @param postalCode number of the postal code
     * @param city name of the city
     * @param address Entity to initialize - User address
     */
    private void processAddress(String streetName, int postalCode, String city, Address address) {
        try {
            postalCodeValidation(postalCode);
        }catch (DataValidationException e){
            setError(POSTAL_CODE_FIELD,e.getMessage());
        }
        address.setStreetName(streetName);
        address.setPostalCode(postalCode);
        address.setCity(city);
    }
    
    /**
     * This method call for validation method and then initialize the properties of the entity
     * @param mail mail addess of user
     * @param account Entity to initialize - User account
     */
    private void processMail(String mail, Account account) {
        try{
            mailValidation(mail);
        } catch (DataValidationException e) {
            setError(MAIL_FIELD,e.getMessage());
        }
        account.setMail(mail);
    }
    
    /**
     * This method call for validation method and then initialize the properties of the entity
     * @param password password of user
     * @param passwordConf confirmation of password
     * @param account Entity to initialize - User account
     */
    private void processPassword(String password, String passwordConf, Account account) {
        try{
            passwordValidation(password,passwordConf);
        } catch (DataValidationException e) {
            setError(PASSWORD_FIELD,e.getMessage());
            setError(CONFIRMATION_FIELD,null);
        }
        account.setPassword(encryptPassword(password));
    }
    
    /**
     * using Jasypt library tu encrypt password effectively.
     * I choose SHA-256 algorithm here, with by default a random "salage"
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
     * This method call for validation method and then initialize the properties of the entity
     * @param title could be "MR", "MME" or "MLLE"
     * @param firstName first name of user
     * @param lastName last name of user
     * @param username alias of user
     * @param account Entity to initialize - User account
     */
    private void processName(String title, String firstName, String lastName, String username, Account account) {
        
        nameValidation(title,firstName,lastName);
        
        account.setTitle(title); //TODO manage case when people let "civilité" in the field
        account.setFirstName(firstName);
        account.setLastName(lastName);
    }
    
    /**
     * this method check if postal code is filled correctly.
     * @param postalCode
     */
    private void postalCodeValidation(int postalCode) throws DataValidationException{
        if (postalCode < 9999 || postalCode >99999){
            throw new DataValidationException("Merci de renseigner un code postal valide");
        }
    }
    
    /**
     * This method check if title, firstname and lastname fields have been filled.
     * @param title title of user
     * @param firstName first name of user
     * @param lastName last name of user
     */
    private void nameValidation(String title, String firstName, String lastName){
        if (title == null)
            setError(TITLE_FIELD,"Merci de renseigner ce champ");
        if (firstName == null)
            setError(FIRST_NAME_FIELD,"Merci de renseigner ce champ");
        if (lastName == null)
            setError(LAST_NAME_FIELD,"Merci de renseigner ce champ");
    }
    
    /**
     * This method check if the mail address format is good and not in the DataBase yet.
     * @param mail user mail address
     * @throws DataValidationException if validation fail
     */
    private void mailValidation(String mail) throws DataValidationException {
        if ( mail != null ) {
            if ( !mail.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new DataValidationException( "Merci de saisir une adresse mail valide." );
            } else if ( !searchByMail( mail ).isEmpty() ) {
                throw new DataValidationException( "Cette adresse email est déjà utilisée, merci d'en choisir une autre." );
            }
        } else {
            throw new DataValidationException( "Merci de saisir une adresse mail." );
        }
    }
    
    /**
     * This method check if there is a valid confirmed password
     *
     * @param password user password
     * @param passwordConf pasword confirmation
     * @throws DataValidationException if password too short or != of passwordConf
     */
    private void passwordValidation(String password, String passwordConf) throws DataValidationException {
        if (password != null && passwordConf != null) {
            if (!password.equals(passwordConf))
                throw new DataValidationException("Le mot de passe renseigné et sa confirmation ne sont pas les mêmes.");
            else if (password.trim().length() < 6)
                throw new DataValidationException("Le mot de passe doit contenir au minimum 3 caractères.");
        } else {
            throw new DataValidationException("Merci de renseigner un mot de passe et le confirmer.");
        }
    }
    
    /**
     * This method search in Data Base the list of Account with this mail address
     * @param mail mail to look for
     * @return a list of Account
     */
    private List<Account> searchByMail(String mail) {
        List<Account> listAccount = accountRepository.searchByMail(mail);
        System.out.println(listAccount);
        return listAccount;
    }
    
    /**
     * This method look for an Account with the couple mail/password when someone
     * try to login on the application
     * @param mail mail from the login attempt
     * @param password password from the login attempt
     * @return the account whose behove this couple mail/password
     */
    private Account findMailPasswordForLogin(String mail, String password){
        //TODO
        return new Account();
    }
}
