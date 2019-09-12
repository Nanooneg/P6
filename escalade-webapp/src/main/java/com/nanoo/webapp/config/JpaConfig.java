package com.nanoo.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * @author nanoo
 * @create 06/09/2019 - 17:46
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.nanoo.consumer"})
public class JpaConfig {
    
    private Properties properties = new Properties();
    {
        try {
            properties.load(getClass().getResourceAsStream("/persistence/jdbc.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.POSTGRESQL);
        vendorAdapter.setGenerateDdl(true);
        
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.nanoo.model");
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        
        return em;
    }
    
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(properties.getProperty("spring.datasource.driver"));
        dataSource.setUrl(properties.getProperty("spring.datasource.url"));
        dataSource.setUsername(properties.getProperty("spring.datasource.username"));
        dataSource.setPassword(properties.getProperty("spring.datasource.password"));
        
        return dataSource;
    }
    
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        
        return transactionManager;
    }
    
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
    
    private Properties additionalProperties() {
        Properties addProperties = new Properties();
        addProperties.setProperty("hibernate.hbm2ddl.auto", properties.getProperty("spring.jpa.hibernate.ddl-auto"));
        addProperties.setProperty("hibernate.show_sql", properties.getProperty("spring.jpa.show-sql"));
        addProperties.setProperty("hibernate.dialect", properties.getProperty("spring.jpa.properties.hibernate.dialect"));
        addProperties.setProperty("hibernate.current_session_context_class", properties.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));
        addProperties.setProperty("hibernate.format_sql", properties.getProperty("spring.jpa.properties.hibernate.format_sql"));
        addProperties.setProperty("hibernate.jdbc.lob.non_contextual_creation", properties.getProperty("spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation"));
        addProperties.setProperty("hibernate.cache.use_second_level_cache",properties.getProperty("spring.jpa.properties.hibernate.cache.use_second_level_cache"));
        addProperties.setProperty("hibernate.cache.region.factory_class",properties.getProperty("spring.jpa.properties.hibernate.cache.region.factory_class"));
        addProperties.setProperty("hibernate.cache.provider_class",properties.getProperty("spring.jpa.properties.hibernate.cache.provider_class"));
        addProperties.setProperty("hibernate.use_sql_comments",properties.getProperty("spring.jpa.use_sql_comments"));
        //addProperties.setProperty("",properties.getProperty("")); // TO DO : Add more properties later
        return addProperties;
    }
}