package banque.entity.client;

import banque.entity.Banque;
import banque.entity.compte.Compte;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CLIENT")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENT")
    private Integer id;

    @Column(name = "NOM", nullable = false)
    private String nom;

    @Column(name = "PRENOM", nullable = false)
    private String prenom;

    @Column(name = "DATE", columnDefinition = "DATE", nullable = false)
    private LocalDate dateNaissance;

    @Embedded
    private Adresse adresse;

    @ManyToOne()
    @JoinColumn(name = "ID_BANQUE", referencedColumnName = "ID_BANK")
    private Banque banque = null;

    @ManyToMany()
    @JoinTable(name = "COMPTE_CLIENT",
            joinColumns = @JoinColumn(name = "ID_CLI", referencedColumnName = "ID_CLIENT"),
            inverseJoinColumns = @JoinColumn(name = "ID_COM", referencedColumnName = "ID_COMPTE"))
    private Set<Compte> comptes = new HashSet<>();


    public Client() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void addBanque(Banque banque) {
        this.banque = banque;
    }

    public void deleteBanque() {
        this.banque = null;
    }

    public void addCompte(Compte compte) {
        compte.addClients(this);
        comptes.add(compte);
    }

    public void deleteCompte(Compte compte) {
        compte.deleteClients(this);
        this.comptes.remove(compte);
    }

    public void deleteCompte() {
        comptes = new HashSet<>();
    }

    public void update(Client clientOld) {
        if (this.nom == null)
            setNom(clientOld.getNom());
        if (this.prenom == null)
            this.setPrenom(clientOld.getPrenom());
        if (this.adresse == null)
            this.setAdresse(clientOld.getAdresse());
        if (this.dateNaissance == null)
            setDateNaissance(clientOld.getDateNaissance());
        if (this.id == null)
            setId(clientOld.getId());
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Set<Compte> getComptes() {
        return comptes;
    }
}
