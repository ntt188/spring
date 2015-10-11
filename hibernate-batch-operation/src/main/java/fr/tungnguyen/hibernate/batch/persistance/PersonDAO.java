package fr.tungnguyen.hibernate.batch.persistance;

public interface PersonDAO {

    void batchInsert(int number);

    void batchUpdateBirthDay();

    void batchInsertJob(int number);

}
