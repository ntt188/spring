package fr.tungnguyen.hibernate.batch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true, nullable = false, insertable = true, updatable = true)
    private Long id;

    @Column(length = 50)
    private String street;

    @Column(length = 50)
    private String city;

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
     * Getter pour street
     * @return la valeur du champ street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Setter pour street
     * @param street La nouvelle valeur du champ street
     */
    public void setStreet(final String street) {
        this.street = street;
    }

    /**
     * Getter pour city
     * @return la valeur du champ city
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter pour city
     * @param city La nouvelle valeur du champ city
     */
    public void setCity(final String city) {
        this.city = city;
    }

}
