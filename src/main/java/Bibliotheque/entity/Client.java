package Bibliotheque.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * The Class Client.
 */
@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {
    
    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID_CLIENT", nullable = false)
    private Integer id;

    /** The nom. */
    @Column(length = 50, nullable = false)
    private String nom;

    /** The prenom. */
    @Column(length = 50, nullable = false)
    private String prenom;

    /** The emprunt. */
    @OneToMany(mappedBy = "client")
    private Set<Emprunt> emprunt;

    /**
     * Instantiates a new client.
     */
    public Client() {
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the nom.
     *
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets the nom.
     *
     * @param nom the new nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Gets the prenom.
     *
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Sets the prenom.
     *
     * @param prenom the new prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Sets the client.
     *
     * @param client the new client
     */
    public void setClient(Client client) {
        setNom(client.getNom());
        setPrenom(client.getPrenom());
    }
}
