package com.nanoo.business.serviceImpl;

import com.nanoo.business.dto.AccountDTO;
import com.nanoo.business.dto.AccountSessionDTO;
import com.nanoo.business.mapper.AccountMapper;
import com.nanoo.business.mapper.AccountSessionMapper;
import com.nanoo.business.serviceContract.AccountService;
import com.nanoo.business.util.DateUtil;
import com.nanoo.consumer.repository.AccountRepository;
import com.nanoo.model.entities.Account;
import com.nanoo.model.enums.EnumRole;
import lombok.Data;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author nanoo
 * @create 11/09/2019 - 17:36
 */
@Service
@Transactional
@Data
public class AccountServiceImpl implements AccountService {
    
    private static final String FORMAT_DATE = "dd/MM/yyyy HH:mm:ss";
    private static final String ENCRYPTION_ALGO = "SHA-256";
    
    private static final String MAIL_FIELD = "mail";
    private static final String PASSWORD_FIELD = "password";
    
    private static final String ERROR_LOG_MESSAGE = "La connection a échoué !";
    private static final String ERROR_REGISTER_MESSAGE = "L'enregistrement a échoué !";
    private static final String SUCCESS_LOG_MESSAGE = "Vous êtes connecté";
    private static final String SUCCESS_REGISTER_MESSAGE = "Votre compte a bien été crée";
    
    private String result;
    private Map<String,String> errors;
    private DateUtil dateUtil;
    
    private final AccountRepository accountRepository;
    
    private final AccountMapper accountMapper;
    private final AccountSessionMapper accountSessionMapper;
    
    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper, AccountSessionMapper accountSessionMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
        this.accountSessionMapper = accountSessionMapper;
    }
    
    
    /**
     * This method save an account in DB
     *
     * @param accountDTO account to save
     */
    @Override
    public void saveAccount(AccountDTO accountDTO) {
        result = "";
        dateUtil = new DateUtil();
        Account existingAccount;
        
        Account account = accountMapper.fromDtoToAccount(accountDTO);
        
        if (accountDTO.getId() != null){
            Optional<Account> oldAccount = accountRepository.findById(accountDTO.getId());
            if (oldAccount.isPresent()){
                existingAccount = oldAccount.get();
                account.setDateOfCreation(existingAccount.getDateOfCreation());
                account.setRoleName(existingAccount.getRoleName());
            }
        }else {
            account.setDateOfCreation(new Date());
            account.setRoleName(EnumRole.USER.getAbbreviation()); // role is set USER by default.
        }
    
        account.setPassword(encryptPassword(account.getPassword()));
        account.setDateOfUpdate(new Date());
    
        
        try {
            accountRepository.save(account);
            result = SUCCESS_REGISTER_MESSAGE;
        }catch (Exception e){
            result = ERROR_REGISTER_MESSAGE;
        }
        
        
    }
    
    /**
     * This method looks for a match in DB
     * It compare a mail/password couple
     *
     * @param accountDTO object who contain fields to compare
     * @return true if the couple match with DB
     */
    @Override
    public AccountSessionDTO searchRegisteredAccount(AccountDTO accountDTO){
        errors = new HashMap<>();
        result = "";
        
        Account account = accountRepository.findByMail(accountDTO.getMail());
        
        if (account == null) {
            setError(MAIL_FIELD, "Aucun compte ne correspond à votre adresse mail");
            result = ERROR_LOG_MESSAGE;
            
            return null;
        }else if (!checkPassword(accountDTO.getPassword(), account.getPassword())) {
            setError(PASSWORD_FIELD, "Le mot de passe renseigné n'est pas correct");
            result = ERROR_LOG_MESSAGE;
    
            return accountSessionMapper.fromAccountToSessionDto(account);
        }else{
            result = SUCCESS_LOG_MESSAGE    ;
            
            return accountSessionMapper.fromAccountToSessionDto(account);
        }
    }
    
    /**
     * This method search an account in DB ans return only chosen parameters.
     *
     * @param idAccount id of account searched
     * @return account with chosen parameters
     */
    @Override
    public AccountDTO searchAccountLightById(Integer idAccount){
        Optional<Account> account = accountRepository.findById(idAccount);
        Account existingAccount;
        
        if (account.isPresent()){
            existingAccount = account.get();
            return accountMapper.fromAccountToDtoLight(existingAccount);
        }
        
        return null;
    }
    
    /**
     * This method search an account in DB.
     *
     * @param idAccount id of account to search
     * @return account if exist
     */
    @Override
    public AccountDTO searchAccountById(int idAccount) {
        Optional<Account> account = accountRepository.findById(idAccount);
        Account existingAccount;
    
        if (account.isPresent()){
            existingAccount = account.get();
            return accountMapper.fromAccountToDto(existingAccount);
        }
    
        return null;
    }
    
    /**
     * This method search in DB if mail is available
     *
     * @param mail mail to compare with DB
     * @return false if mail is already use for another account
     */
    @Override
    public boolean checkMailAvailability(String mail) {
        return accountRepository.findByMail(mail) == null;
    }
    
    /**
     * This method search in DB if mail is available for update
     *
     * @param mail mail to compare with DB
     * @return false if mail is already use for another account
     */
    @Override
    public boolean checkMailAvailabilityForUpdate(String mail, Integer userId) {
        
        Account account = accountRepository.findByMail(mail);
        
        if (account == null)
            return true;
        else return account.getId().equals(userId);
    }
    
    /**
     * using Jasypt library to encrypt password effectively
     * with SHA-256 algorithm. By default a random salt
     * and a huge iteration number of the hash method.
     *
     * @param password String to encrypt
     * @return string with a length of 56 who contains the hash in base64.
     */
    private String encryptPassword(String password) {
        ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
        passwordEncryptor.setAlgorithm(ENCRYPTION_ALGO);
        passwordEncryptor.setPlainDigest( false );
        
        return passwordEncryptor.encryptPassword(password);
    }
    
    /**
     * using Jasypt library to compare password from login form
     * with encrypted password in DB.
     *
     * @param plainPassword password not encrypted
     * @param encryptedPassword password encrypted
     * @return {@code false} if there is no match
     */
    private boolean checkPassword(String plainPassword, String encryptedPassword) {
        ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
        passwordEncryptor.setAlgorithm(ENCRYPTION_ALGO);
        passwordEncryptor.setPlainDigest( false );
        
        return passwordEncryptor.checkPassword(plainPassword,encryptedPassword);
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
