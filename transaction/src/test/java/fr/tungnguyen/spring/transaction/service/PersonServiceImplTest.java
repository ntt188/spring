package fr.tungnguyen.spring.transaction.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.tungnguyen.spring.transaction.config.RootConfig;
import fr.tungnguyen.spring.transaction.dao.PersonDAO;
import fr.tungnguyen.spring.transaction.exception.CheckedException;
import fr.tungnguyen.spring.transaction.exception.UncheckedException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class })
public class PersonServiceImplTest {

    @Autowired
    private PersonService personService;
    @Autowired
    private PersonDAO personDAO;

    @Before
    public void setUp() {
        personDAO.clear();
    }

    @Test
    public void testCreateWithoutTransactional_DAORequired() {
        personService.createWithoutTransactional_DAORequired();
        assertEquals(3, personDAO.countAll().longValue());
    }

    @Test
    public void testCreateWithoutTransactional_DAONested() {
        personService.createWithoutTransactional_DAONested();
        assertEquals(3, personDAO.countAll().longValue());
    }

    @Test
    public void testCreateWithTransactional_DAORequired() {
        personService.createWithTransactional_DAORequired();
        assertEquals(3, personDAO.countAll().longValue());
    }

    @Test
    public void testCreateWithTransactional_DAORequiresNew() {
        personService.createWithTransactional_DAORequiresNew();
        assertEquals(3, personDAO.countAll().longValue());
    }

    @Test
    public void testCreateWithTransactional_DAONested() {
        personService.createWithTransactional_DAONested();
        assertEquals(3, personDAO.countAll().longValue());
    }

    @Test
    public void testCreateWithTransactionalThrowCheckedException_DAORequired() {
        try {
            personService.createWithTransactionalThrowCheckedException_DAORequired();
            fail("CheckedException has to been throwed");
        } catch (CheckedException e) {
            // OK
        }
        assertEquals(3, personDAO.countAll().longValue());
    }

    @Test
    public void testCreateWithTransactionalThrowUncheckedException_DAORequired() {
        try {
            personService.createWithTransactionalThrowUncheckedException_DAORequired();
            fail("CheckedException has to been throwed");
        } catch (UncheckedException e) {
            // OK
        }
        assertEquals(0, personDAO.countAll().longValue());
    }

    @Test
    public void testCreateWithTransactionalRollbackForCheckedExceptionThrowCheckedExceptionWithoutInterruption_DAORequired() {
        personService.createWithTransactionalRollbackForCheckedExceptionThrowCheckedExceptionWithoutInterruption_DAORequired();
        assertEquals(3, personDAO.countAll().longValue());
    }

    @Test
    public void testCreateWithTransactionalRollbackForCheckedExceptionThrowCheckedException_DAORequired() {
        try {
            personService.createWithTransactionalRollbackForCheckedExceptionThrowCheckedException_DAORequired();
            fail("CheckedException has to been throwed");
        } catch (CheckedException e) {
            // OK
        }
        assertEquals(0, personDAO.countAll().longValue());
    }

    @Test
    public void testCreateWithTransactionalThrowUncheckedException_DAORequiresNew() {
        try {
            personService.createWithTransactionalThrowUncheckedException_DAORequiresNew();
            fail("CheckedException has to been throwed");
        } catch (UncheckedException e) {
            // OK
        }
        assertEquals(3, personDAO.countAll().longValue());
    }

    @Test
    public void testCreateWithTransactionalRollbackForUncheckedExceptionThrowUncheckedExceptionWithoutInterruption_DAORequired() {
        personService
        .createWithTransactionalRollbackForUncheckedExceptionThrowUncheckedExceptionWithoutInterruption_DAORequired();
        assertEquals(3, personDAO.countAll().longValue());
    }

    @Test
    public void testCreateWithoutTransactional_DAORequiredThrowCheckedException() {
        try {
            personService.createWithoutTransactional_DAORequiredThrowCheckedException();
            fail("CheckedException has to been throwed");
        } catch (CheckedException e) {
            // OK
        }
        assertEquals(2, personDAO.countAll().longValue());
    }

    @Test
    public void testCreateWithoutTransactional_DAORequiredThrowCheckedExceptionWithoutInterruption() {
        personService.createWithoutTransactional_DAORequiredThrowCheckedExceptionWithoutInterruption();
        assertEquals(3, personDAO.countAll().longValue());
    }

    @Test
    public void testCreateWithTransactional_DAORequiredThrowCheckedException() throws Exception {
        try {
            personService.createWithTransactional_DAORequiredThrowCheckedException();
            fail("CheckedException has to been throwed");
        } catch (CheckedException e) {
            // OK
        }
        assertEquals(2, personDAO.countAll().longValue());
    }

    @Test
    public void testCreateWithTransactional_DAORequiredThrowUncheckedException() throws Exception {
        try {
            personService.createWithTransactional_DAORequiredThrowUncheckedException();
            fail("UncheckedException has to been throwed");
        } catch (UncheckedException e) {
            // OK
        }
        assertEquals(0, personDAO.countAll().longValue());
    }

    @Test
    public void testCreateWithTransactional_DAORequiresNewThrowUncheckedException() throws Exception {
        try {
            personService.createWithTransactional_DAORequiresNewThrowUncheckedException();
            fail("UncheckedException has to been throwed");
        } catch (UncheckedException e) {
            // OK
        }
        assertEquals(1, personDAO.countAll().longValue());
    }

    @Test
    public void testCreateWithTransactional_DAORequiresNewThrowUncheckedExceptionWithoutInterruption() throws Exception {
        personService.createWithTransactional_DAORequiresNewThrowUncheckedExceptionWithoutInterruption();
        assertEquals(2, personDAO.countAll().longValue());
    }

    @Test
    public void testCreateWithTransactionalThrowUncheckedException_DAONested() throws Exception {
        try {
            personService.createWithTransactionalThrowUncheckedException_DAONested();
            fail("UncheckedException has to been throwed");
        } catch (UncheckedException e) {
            // OK
        }
        assertEquals(0, personDAO.countAll().longValue());
    }

    @Test
    public void testCreateWithTransactional_DAONestedThrowUncheckedExceptionWithoutInterruption() throws Exception {
        personService.createWithTransactional_DAONestedThrowUncheckedExceptionWithoutInterruption();
        assertEquals(2, personDAO.countAll().longValue());
    }
}
