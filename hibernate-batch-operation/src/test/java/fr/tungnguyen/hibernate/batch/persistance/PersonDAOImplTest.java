package fr.tungnguyen.hibernate.batch.persistance;

import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.tungnguyen.hibernate.batch.config.DAOConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DAOConfig.class })
public class PersonDAOImplTest {

    private static final Logger LOGGER = LogManager.getLogger(PersonDAOImplTest.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private PersonDAO personDAO;

    @Before
    public void setUp() {
        clearTablePerson();
    }

    private void clearTablePerson() {
        sessionFactory.openStatelessSession().createQuery("delete from Person").executeUpdate();
    }

    @Test
    public void testBatchInsert() {
        Long start = new Date().getTime();
        personDAO.batchInsert();
        Long end = new Date().getTime();
        System.out.println("Time : " + (end - start));

    }
}
