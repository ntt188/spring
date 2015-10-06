package fr.tungnguyen.hibernate.batch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true, nullable = false, insertable = true, updatable = true)
    private Long id;

    @Column(unique = false, nullable = true, insertable = true, updatable = true, length = 40)
    private String firstName;

    @Column(unique = false, nullable = true, insertable = true, updatable = true, length = 40)
    private String lastName;

    @Column(unique = false, nullable = true, insertable = true, updatable = true)
    @Temporal(TemporalType.DATE)
    private Date birthDay;

    /**
     * Constructeur
     */
    public Person() {
        super();
    }

    /**
     * Getter pour id
     * @return la valeur du champ id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter pour id
     * @param id La nouvelle valeur du champ id
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Getter pour firstName
     * @return la valeur du champ firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter pour firstName
     * @param firstName La nouvelle valeur du champ firstName
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter pour lastName
     * @return la valeur du champ lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter pour lastName
     * @param lastName La nouvelle valeur du champ lastName
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter pour birthDay
     * @return la valeur du champ birthDay
     */
    public Date getBirthDay() {
        return birthDay;
    }

    /**
     * Setter pour birthDay
     * @param birthDay La nouvelle valeur du champ birthDay
     */
    public void setBirthDay(final Date birthDay) {
        this.birthDay = birthDay;
    }
}
