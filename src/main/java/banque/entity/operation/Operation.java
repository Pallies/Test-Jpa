package banque.entity.operation;

import banque.entity.compte.Compte;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "OPERATION")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "OP_TYPE")
@DiscriminatorValue("OP")
public class Operation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_OP")
    private Integer id;

    @Column(name = "DATE", columnDefinition = "DATE", nullable = false)
    private LocalDate date;

    @Column(name = "MONTANT", precision = 10, scale = 2)
    private Double montant;

    @Column(name = "MOTIF")
    private String motif;

    @ManyToOne()
    @JoinColumn(name = "ID_C", referencedColumnName = "ID_COMPTE")
    private Compte compte = null;

    public Operation() {
    }

    public Operation(LocalDate date, Double montant, String motif) {
        this.date = date;
        this.montant = montant;
        this.motif = motif;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}


