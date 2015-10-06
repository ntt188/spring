package fr.tungnguyen.hibernate.batch.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "fr.tungnguyen.hibernate.batch.persistance" })
public class DAOConfig {

    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(org.hsqldb.jdbcDriver.class.getName());
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        dataSource.setUrl("jdbc:hsqldb:hsql://localhost:9001/");
        return dataSource;
    }

    @Autowired
    @Bean
    public SessionFactory getSessionFactory(final DataSource dataSource) {
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionBuilder.scanPackages("fr.tungnguyen.hibernate.batch.model");
        sessionBuilder.setProperty("hibernate.show_sql", "true");
        sessionBuilder.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        sessionBuilder.setProperty("hibernate.order_updates", "true");
        sessionBuilder.setProperty("hibernate.order_inserts", "true");
        sessionBuilder.setProperty("hibernate.jdbc.batch_size", "30");
        sessionBuilder.setProperty("hibernate.hbm2ddl.auto", "update");

        return sessionBuilder.buildSessionFactory();
    }

    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(final SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
        transactionManager.setNestedTransactionAllowed(true);
        return transactionManager;
    }
}
