package fr.tungnguyen.hibernate.batch.persistance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.tungnguyen.hibernate.batch.modelb.PersonB;

@Component
public class PersonBPersistance {

    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession() {
        return sessionFactory.openSession();
    }

    public void batchInsert(final int number) {
        Session session = openSession();
        Transaction tx = session.beginTransaction();
        for (int i = 1; i <= number; i++) {
            PersonB person = new PersonB();
            person.setFirstName("FirstName" + i);
            session.save(person);
        }
        session.flush();
        session.clear();

        tx.commit();
        session.close();
    }
}
