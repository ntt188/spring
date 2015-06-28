package fr.tungnguyen.spring.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.tungnguyen.spring.transaction.dao.PersonDAO;
import fr.tungnguyen.spring.transaction.exception.CheckedException;
import fr.tungnguyen.spring.transaction.exception.UncheckedException;

@Service
class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO personDAO;

    @Override
    public void createWithoutTransactional_DAORequired() {
        personDAO.createRequired(1L);
        personDAO.createRequired(2L);
        personDAO.createRequired(3L);
    }

    @Override
    public void createWithoutTransactional_DAONested() {
        personDAO.createNested(1L);
        personDAO.createNested(2L);
        personDAO.createNested(3L);
    }

    @Override
    @Transactional
    public void createWithTransactional_DAORequired() {
        personDAO.createRequired(1L);
        personDAO.createRequired(2L);
        personDAO.createRequired(3L);
    }

    @Override
    @Transactional
    public void createWithTransactional_DAORequiresNew() {
        personDAO.createRequiresNew(1L);
        personDAO.createRequiresNew(2L);
        personDAO.createRequiresNew(3L);
    }

    @Override
    @Transactional
    public void createWithTransactional_DAONested() {
        personDAO.createNested(1L);
        personDAO.createNested(2L);
        personDAO.createNested(3L);
    }

    @Override
    @Transactional
    public void createWithTransactionalThrowCheckedException_DAORequired() throws CheckedException {
        personDAO.createRequired(1L);
        personDAO.createRequired(2L);
        personDAO.createRequired(3L);
        throw new CheckedException();
    }

    @Override
    @Transactional(rollbackFor = CheckedException.class)
    public void createWithTransactionalRollbackForCheckedExceptionThrowCheckedException_DAORequired() throws CheckedException {
        personDAO.createRequired(1L);
        personDAO.createRequired(2L);
        personDAO.createRequired(3L);
        throw new CheckedException();
    }

    @Override
    @Transactional
    public void createWithTransactionalThrowUncheckedException_DAORequired() {
        personDAO.createRequired(1L);
        personDAO.createRequired(2L);
        personDAO.createRequired(3L);
        throw new UncheckedException();
    }

    @Override
    @Transactional(rollbackFor = CheckedException.class)
    public void createWithTransactionalRollbackForCheckedExceptionThrowCheckedExceptionWithoutInterruption_DAORequired() {
        personDAO.createRequired(1L);
        personDAO.createRequired(2L);
        personDAO.createRequired(3L);
        try {
            throw new CheckedException();
        } catch (CheckedException e) {
        }
    }

    @Override
    @Transactional
    public void createWithTransactionalThrowUncheckedException_DAORequiresNew() {
        personDAO.createRequiresNew(1L);
        personDAO.createRequiresNew(2L);
        personDAO.createRequiresNew(3L);
        throw new UncheckedException();
    }

    @Override
    @Transactional(rollbackFor = CheckedException.class)
    public void createWithTransactionalRollbackForUncheckedExceptionThrowUncheckedExceptionWithoutInterruption_DAORequired() {
        personDAO.createRequired(1L);
        personDAO.createRequired(2L);
        personDAO.createRequired(3L);
        try {
            throw new UncheckedException();
        } catch (UncheckedException e) {
        }
    }

    @Override
    public void createWithoutTransactional_DAORequiredThrowCheckedException() throws CheckedException {
        personDAO.createRequired(1L);
        personDAO.createRequiredThrowCheckedException(2L);
        personDAO.createRequired(3L);
    }

    @Override
    public void createWithoutTransactional_DAORequiredThrowCheckedExceptionWithoutInterruption() {
        personDAO.createRequired(1L);
        createRequiredThrowCheckedExceptionWithoutInterruption(2L);
        personDAO.createRequired(3L);
    }

    @Override
    @Transactional
    public void createWithTransactional_DAORequiredThrowCheckedException() throws CheckedException {
        personDAO.createRequired(1L);
        personDAO.createRequiredThrowCheckedException(2L);
        personDAO.createRequired(3L);
    }

    @Override
    @Transactional
    public void createWithTransactional_DAORequiredThrowUncheckedException() {
        personDAO.createRequired(1L);
        personDAO.createRequiredThrowUncheckedException(2L);
        personDAO.createRequired(3L);
    }

    @Override
    @Transactional
    public void createWithTransactionalThrowUncheckedException_DAONested() {
        personDAO.createNested(1L);
        personDAO.createNested(2L);
        personDAO.createNested(3L);
        throw new UncheckedException();
    }

    @Override
    @Transactional
    public void createWithTransactional_DAONestedThrowUncheckedExceptionWithoutInterruption() {
        personDAO.createNested(1L);
        try {
            personDAO.createNestedThrowUncheckedException(2L);
        } catch (Exception e) {
        }
        personDAO.createNested(3L);
    }

    @Override
    @Transactional
    public void createWithTransactional_DAORequiresNewThrowUncheckedException() {
        personDAO.createRequiresNew(1L);
        personDAO.createRequiresNewThrowUncheckedException(2L);
        personDAO.createRequiresNew(3L);
    }

    @Override
    @Transactional
    public void createWithTransactional_DAORequiresNewThrowUncheckedExceptionWithoutInterruption() {
        personDAO.createRequiresNew(1L);
        try {
            personDAO.createRequiresNewThrowUncheckedException(2L);
        } catch (Exception e) {
            // Continue
        }
        personDAO.createRequiresNew(3L);
    }

    private void createRequiredThrowCheckedExceptionWithoutInterruption(final Long id) {
        try {
            personDAO.createRequiredThrowCheckedException(id);
        } catch (CheckedException e) {
        }
    }

}
