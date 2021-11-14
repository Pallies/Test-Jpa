package banque.entity.compte;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "ASSURANCE_VIE")
public class AssuranceVie extends Compte implements Serializable {

    @Column(name = "DATE_END", columnDefinition = "DATE")
    private LocalDate dateFin;

    @Column(name = "TAUX", precision = 10, scale = 2, nullable = true)
    private Double taux;

    public AssuranceVie() {
    }

    public AssuranceVie(LocalDate dateEnd, Double taux) {
        dateFin = dateEnd;
        this.taux = taux;
    }

    public void updateCompte(Compte compteOld) {
        AssuranceVie assurance = (AssuranceVie) compteOld;
        if (this.dateFin == null)
            setDateFin(assurance.getDateFin());
        if (this.taux == null)
            setTaux(assurance.getTaux());
        if (this.getNumero() == null)
            this.setNumero(assurance.getNumero());
        if (this.getSolde() == null)
            setSolde(assurance.getSolde());
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }
}
