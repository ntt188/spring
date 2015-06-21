package fr.tungnguyen.spring.transaction.service;

import fr.tungnguyen.spring.transaction.exception.CheckedException;

public interface PersonService {

    void createWithoutTransactional_DAORequired();

    void createWithoutTransactional_DAONested();

    void createWithoutTransactional_DAORequiredThrowCheckedException() throws CheckedException;

    void createWithoutTransactional_DAORequiredThrowCheckedExceptionWithoutInterruption();

    void createWithTransactional_DAORequired();

    void createWithTransactional_DAORequiresNew();

    void createWithTransactional_DAONested();

    void createWithTransactionalThrowCheckedException_DAORequired() throws CheckedException;

    void createWithTransactionalThrowUncheckedException_DAORequired();

    void createWithTransactionalThrowUncheckedException_DAORequiresNew();

    void createWithTransactionalRollbackForCheckedExceptionThrowCheckedExceptionWithoutInterruption_DAORequired();

    void createWithTransactionalRollbackForCheckedExceptionThrowCheckedException_DAORequired() throws CheckedException;

    void createWithTransactionalRollbackForUncheckedExceptionThrowUncheckedExceptionWithoutInterruption_DAORequired();

    void createWithTransactional_DAORequiredThrowCheckedException() throws CheckedException;

    void createWithTransactional_DAORequiredThrowUncheckedException();

    void createWithTransactional_DAORequiresNewThrowUncheckedException();

    void createWithTransactional_DAORequiresNewThrowUncheckedExceptionWithoutInterruption();

    void createWithTransactionalThrowUncheckedException_DAONested();

    void createWithTransactional_DAONestedThrowUncheckedExceptionWithoutInterruption();
}
