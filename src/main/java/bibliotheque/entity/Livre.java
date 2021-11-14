package bibliotheque.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * The Class Livre.
 */
@Entity
@Table(name = "LIVRE")
public class Livre implements Serializable {

    /** The id. */
    @Id
    private Integer id;

    /** The titre. */
    @Column(nullable = false)
    private String titre;

    /** The auteur. */
    @Column(length = 50, nullable = false)
    private String auteur;

    /** The emprunts. */
    @ManyToMany
    @JoinTable(name = "COMPO",
            joinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID_EMPRUNT"))
    private List<Emprunt> emprunts;

    /**
     * Instantiates a new livre.
     */
    public Livre() {
    }

    /**
     * Instantiates a new livre.
     *
     * @param id the id
     * @param titre the titre
     * @param auteur the auteur
     */
    public Livre(int id, String titre, String auteur) {
        setId(id);
        setTitre(titre);
        setAuteur(auteur);
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return new StringBuilder()
                .append("id=").append(id)
                .append(", titre : ").append(titre)
                .append(", auteur : ").append(auteur).toString();
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
     * Gets the titre.
     *
     * @return the titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Sets the titre.
     *
     * @param titre the new titre
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * Gets the auteur.
     *
     * @return the auteur
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     * Sets the auteur.
     *
     * @param auteur the new auteur
     */
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    /**
     * Sets the livre.
     *
     * @param livre the livre
     */
    public void SetLivre(Livre livre) {
        setTitre(livre.getTitre());
        setAuteur(livre.getAuteur());
    }
}
