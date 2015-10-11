package fr.tungnguyen.hibernate.batch.persistance;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.tungnguyen.hibernate.batch.config.DAOConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DAOConfig.class })
public class PersonDAOImplTest {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private PersonDAO personDAO;
    @Autowired
    private PersonBPersistance personBPersistance;

    private void clearDB() {
        sessionFactory.openStatelessSession().createQuery("delete from Person").executeUpdate();
        sessionFactory.openStatelessSession().createQuery("delete from Address").executeUpdate();
        sessionFactory.openStatelessSession().createQuery("delete from Job").executeUpdate();
    }

    @Test
    public void testBatchInsert() {
        clearDB();
        personDAO.batchInsertJob(10000);
        Long start = new Date().getTime();
        personDAO.batchInsert(10000);
        Long end = new Date().getTime();
        System.out.println("Time : " + (end - start));
        printHeapStatistics();
    }

    @Test
    public void testBatchInsertPersonB() {
        clearDB();
        Long start = new Date().getTime();
        personBPersistance.batchInsert(1000000);
        Long end = new Date().getTime();
        System.out.println("Time : " + (end - start));
        printHeapStatistics();
    }

    @Test
    public void testBatchUpdate() {
        Long start = new Date().getTime();
        personDAO.batchUpdateBirthDay();
        Long end = new Date().getTime();
        System.out.println("Time : " + (end - start));
    }

    private void printHeapStatistics() {

        int mb = 1024 * 1024;

        // Getting the runtime reference from system
        Runtime runtime = Runtime.getRuntime();

        System.out.println("##### Heap utilization statistics [MB] #####");

        // Print used memory
        System.out.println("Used Memory:" + (runtime.totalMemory() - runtime.freeMemory()) / mb);

        // Print free memory
        System.out.println("Free Memory:" + runtime.freeMemory() / mb);

        // Print total available memory
        System.out.println("Total Memory:" + runtime.totalMemory() / mb);

        // Print Maximum available memory
        System.out.println("Max Memory:" + runtime.maxMemory() / mb);
    }
}
