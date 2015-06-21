package fr.tungnguyen.spring.transaction.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.tungnguyen.spring.transaction.dao.PersonDAO;
import fr.tungnguyen.spring.transaction.service.PersonService;

/**
 * Project root config
 * @author tungnguyen
 *
 */
@EnableTransactionManagement
@Configuration
@Import(DAOConfig.class)
@ComponentScan(basePackageClasses = { PersonDAO.class, PersonService.class })
public class RootConfig {

}
