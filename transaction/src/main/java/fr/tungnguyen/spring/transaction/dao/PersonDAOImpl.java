package fr.tungnguyen.spring.transaction.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.tungnguyen.spring.transaction.exception.CheckedException;
import fr.tungnguyen.spring.transaction.exception.UncheckedException;
import fr.tungnguyen.spring.transaction.model.Person;

@Repository
class PersonDAOImpl implements PersonDAO {

    private static final Logger LOGGER = LogManager.getLogger(PersonDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    private void create(final Long id) {
        Person person = new Person();
        person.setId(id);
        sessionFactory.getCurrentSession().save(person);
        LOGGER.debug("Person " + id + " created");
    }

    private void createAndThrowCheckedException(final Long id) throws CheckedException {
        create(id);
        LOGGER.debug("throw checked exception");
        throw new CheckedException();
    }

    private void createAndThrowUncheckedException(final Long id) {
        create(id);
        LOGGER.debug("throw unchecked exception");
        throw new UncheckedException();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void createRequired(final Long id) {
        create(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void createRequiredThrowCheckedException(final Long id) throws CheckedException {
        createAndThrowCheckedException(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void createRequiredThrowUncheckedException(final Long id) {
        createAndThrowUncheckedException(id);
    }

    @Override
    @Transactional(rollbackFor = CheckedException.class, propagation = Propagation.REQUIRED)
    public void createRequiredThrowCheckedExceptionRollbackForCheckedException(final Long id) throws CheckedException {
        createAndThrowCheckedException(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createRequiresNew(final Long id) {
        create(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createRequiresNewThrowCheckedException(final Long id) throws CheckedException {
        createAndThrowCheckedException(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createRequiresNewThrowUncheckedException(final Long id) {
        createAndThrowUncheckedException(id);
    }

    @Override
    @Transactional(rollbackFor = CheckedException.class, propagation = Propagation.REQUIRES_NEW)
    public void createRequiresNewThrowCheckedExceptionRollbackForCheckedException(final Long id) throws CheckedException {
        createAndThrowCheckedException(id);
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void createNested(final Long id) {
        create(id);
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void createNestedThrowCheckedException(final Long id) throws CheckedException {
        createAndThrowCheckedException(id);
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void createNestedThrowUncheckedException(final Long id) {
        createAndThrowUncheckedException(id);
    }

    @Override
    @Transactional(rollbackFor = CheckedException.class, propagation = Propagation.NESTED)
    public void createNestedThrowCheckedExceptionRollbackForCheckedException(final Long id) throws CheckedException {
        createAndThrowCheckedException(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Long countAll() {
        return (Long)sessionFactory.getCurrentSession().createQuery("select count(id) from Person").uniqueResult();
    }

    @Override
    @Transactional
    public void clear() {
        sessionFactory.getCurrentSession().createQuery("delete from Person").executeUpdate();
    }
}
