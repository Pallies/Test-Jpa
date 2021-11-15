package banque.entity.compte;

import banque.entity.operation.Operation;
import banque.entity.operation.Retrait;
import banque.entity.operation.Virement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "LIVRET_A")
public class LivretA extends Compte implements Serializable {

    @Column(name = "TAUX",precision = 10,scale = 2,nullable = true)
    private Double taux;

    public LivretA() {
    }
    public LivretA(Double taux){
    this.taux=taux;
    }

    @Override
    public void updateCompte(Compte compteOld) {
        LivretA assurance = (LivretA) compteOld;
        if (this.taux == null)
            setTaux(assurance.getTaux());
        if (this.getNumero() == null)
            this.setNumero(assurance.getNumero());
        if (this.getSolde() == null)
            setSolde(assurance.getSolde());
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }
}
