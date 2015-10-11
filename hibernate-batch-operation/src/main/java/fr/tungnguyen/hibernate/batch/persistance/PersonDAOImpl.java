package fr.tungnguyen.hibernate.batch.persistance;

import java.util.Date;

import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.tungnguyen.hibernate.batch.model.Address;
import fr.tungnguyen.hibernate.batch.model.Job;
import fr.tungnguyen.hibernate.batch.model.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void batchInsertJob(final int number) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        for (int i = 1; i <= number; i++) {
            Job job = new Job();
            job.setName("Name" + i);
            session.save(job);

            if (i % 100 == 0) {
                session.flush();
                session.clear();
            }
        }

        tx.commit();
        session.close();
    }

    @Override
    public void batchInsert(final int number) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        for (int i = 1; i <= number; i++) {
            Person person = new Person();
            person.setLastName("LastName" + i);
            session.save(person);

            Address address = new Address();
            address.setCity("city" + i);
            session.save(address);

            updateJob(session, i);

            if (i % 100 == 0) {
                session.flush();
                session.clear();
            }
        }

        session.getTransaction().commit();
        session.close();
    }

    private void updateJob(final Session session, final int i) {
        session.createQuery("update Job set name = :new_name where name = :name").setString("new_name", "Name -- " + i)
                .setString("name", "Name" + i).executeUpdate();
    }

    private Job findJob(final Session session, final int i) {
        return (Job)session.createQuery("from Job where name = :name").setString("name", "Name" + i).uniqueResult();
    }

    @Override
    public void batchUpdateBirthDay() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        ScrollableResults scrollableResults = session.createQuery("from Person").scroll();
        int count = 0;
        while (scrollableResults.next()) {
            Person person = (Person)scrollableResults.get(0);
            person.setBirthDay(new Date());
            if (++count % 50 == 0) {
                session.flush();
                session.clear();
            }
        }

        tx.commit();
        session.close();
    }
}
