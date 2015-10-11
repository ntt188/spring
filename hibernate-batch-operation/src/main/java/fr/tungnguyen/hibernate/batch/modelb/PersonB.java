package fr.tungnguyen.hibernate.batch.modelb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class PersonB {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true, nullable = false, insertable = true, updatable = true)
    private Long id;

    @Column(unique = false, nullable = true, insertable = true, updatable = true, length = 40)
    private String firstName;

    /**
     * Constructeur
     */
    public PersonB() {
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
}
