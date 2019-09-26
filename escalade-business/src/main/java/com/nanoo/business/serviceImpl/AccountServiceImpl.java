package com.nanoo.business.serviceImpl;

import com.nanoo.business.dto.AccountDTO;
import com.nanoo.business.mapper.AccountMapper;
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

import java.util.HashMap;
import java.util.Map;

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
    
    private String result;
    private Map<String,String> errors;
    
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountMapper accountMapper;
    
    private DateUtil dateUtil;
    
    /**
     * TODO
     * @param accountDTO
     * @return
     */
    @Override
    public void saveAccount(AccountDTO accountDTO){
        result = "";
        dateUtil = new DateUtil()
;
        Account account = accountMapper.fromDtoToAccount(accountDTO);
        account.setTitle(processTitle(account.getTitle()));
        account.setRoleName(EnumRole.USER); // role is set USER by default.
        account.setPassword(encryptPassword(account.getPassword()));
        account.setDateOfCreation(dateUtil.getCurrentDateTime());
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
        errors = new HashMap<>();
        result = "La connection a échoué !";
        
        Account account = accountRepository.findFirstByMail(accountDTO.getMail());
        
        if (account == null) {
            setError(MAIL_FIELD, "Aucun compte ne correspond à votre adresse mail");
            return accountDTO;
        }else if (!checkPassword(accountDTO.getPassword(), account.getPassword())) {
            setError(PASSWORD_FIELD, "Le mot de passe renseigné n'est pas correct");
            return accountDTO;
        }else{
            result = "";
            return accountMapper.fromAccountToDtoLight(account);
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
     * save errors in a Map
     * @param champ field to treat
     * @param message error message associated to field name
     */
    private void setError(String champ, String message){
        errors.put(champ,message);
    }
}
