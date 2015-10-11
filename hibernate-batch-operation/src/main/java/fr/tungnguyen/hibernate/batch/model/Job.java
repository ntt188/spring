package fr.tungnguyen.hibernate.batch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true, nullable = false, insertable = true, updatable = true)
    private Long id;

    @Column(length = 50)
    private String name;

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
     * Getter pour name
     * @return la valeur du champ name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter pour name
     * @param name La nouvelle valeur du champ name
     */
    public void setName(String name) {
        this.name = name;
    }

}
