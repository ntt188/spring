package fr.tungnguyen.spring.transaction.dao;

import fr.tungnguyen.spring.transaction.exception.CheckedException;

public interface PersonDAO {

    void createRequired(Long id);

    void createRequiredThrowCheckedException(Long id) throws CheckedException;

    void createRequiredThrowUncheckedException(Long id);

    void createRequiredThrowCheckedExceptionRollbackForCheckedException(Long id) throws CheckedException;

    void createRequiresNew(Long id);

    void createRequiresNewThrowCheckedException(Long id) throws CheckedException;

    void createRequiresNewThrowUncheckedException(Long id);

    void createRequiresNewThrowCheckedExceptionRollbackForCheckedException(Long id) throws CheckedException;

    void createNested(Long id);

    void createNestedThrowCheckedException(Long id) throws CheckedException;

    void createNestedThrowUncheckedException(Long id);

    void createNestedThrowCheckedExceptionRollbackForCheckedException(Long id) throws CheckedException;

    Long countAll();

    void clear();

}
