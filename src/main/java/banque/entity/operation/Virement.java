package banque.entity.operation;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("V")
public class Virement extends Operation {


    @Column(name = "BENEFI")
    private String beneficiaire;

    public Virement() {
    }

    public  Virement(LocalDate date, Double montant, String motif, String beneficiaire) {
        super(date, montant, motif);
        this.beneficiaire = beneficiaire;
    }

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }
}
