package banque.entity.client;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {


    public Adresse() {

    }

    @Column(name = "NUM")
    private String numero;

    @Column(name = "STREET",nullable = false)
    private String rue;

    @Column(name = "CODE",nullable = false,length = 5)
    private int codePostal;

    @Column(name = "CITY",nullable = false)
    private String ville;

    public Adresse(String numero, String rue, int codePostal, String ville) {
        this.numero = numero;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }
}
