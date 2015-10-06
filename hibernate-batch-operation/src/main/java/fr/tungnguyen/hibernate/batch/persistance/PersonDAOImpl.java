package fr.tungnguyen.hibernate.batch.persistance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.tungnguyen.hibernate.batch.model.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void batchInsert() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        for (int i = 1; i <= 100; i++) {
            Person person = new Person();
            person.setLastName("LastName" + i);
            session.save(person);

            if (i % 30 == 0) {
                session.flush();
                session.clear();
            }
        }

        tx.commit();
        session.close();
    }
}
