package bibliotheque.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * The Class Emprunt.
 */
@Entity
@Table(name = "EMPRUNT")
public class Emprunt implements Serializable {
    
    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EMPRUNT")
    private Integer id;

    /** The date start. */
    @Column(name = "DATE_DEBUT", columnDefinition = "DATE", nullable = false)
    private LocalDate dateStart;

    /** The date end. */
    @Column(name = "DATE_FIN", columnDefinition = "DATE")
    private LocalDate dateEnd;

    /** The delai. */
    @Column
    private Integer delai;

    /** The client. */
    @ManyToOne()
    @JoinColumn(name = "ID_CLI", referencedColumnName = "ID_CLIENT")
    private Client client;

    /** The livres. */
    @ManyToMany(mappedBy = "emprunts")
    private Set<Livre> livres;

    /**
     * Instantiates a new emprunt.
     */
    public Emprunt() {
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
     * Gets the date start.
     *
     * @return the date start
     */
    public LocalDate getDateStart() {
        return dateStart;
    }

    /**
     * Sets the date start.
     *
     * @param dateStart the new date start
     */
    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    /**
     * Gets the date end.
     *
     * @return the date end
     */
    public LocalDate getDateEnd() {
        return dateEnd;
    }

    /**
     * Sets the date end.
     *
     * @param dateEnd the new date end
     */
    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    /**
     * Gets the delai.
     *
     * @return the delai
     */
    public Integer getDelai() {
        return delai;
    }

    /**
     * Sets the delai.
     *
     * @param delai the new delai
     */
    public void setDelai(Integer delai) {
        this.delai = delai;
    }

    /**
     * Gets the client.
     *
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * Sets the client.
     *
     * @param client the new client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Gets the livres.
     *
     * @return the livres
     */
    public Set<Livre> getLivres() {
        return livres;
    }

    /**
     * Sets the livres.
     *
     * @param livres the new livres
     */
    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }
}
