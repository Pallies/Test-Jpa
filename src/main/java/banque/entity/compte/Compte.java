package banque.entity.compte;

import banque.entity.client.Client;
import banque.entity.operation.Operation;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "COMPTE")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMPTE")
    private Integer id;

    @Column(name = "NUMERO", length = 15)
    private String numero;

    @Column(name = "SOLDE", precision = 10, scale = 2, nullable = true)
    private Double solde;

    @ManyToMany(mappedBy = "comptes")
    private Set<Client> clients = new HashSet<>();

    @OneToMany(mappedBy = "compte")
    private Set<Operation> operations = new HashSet<>();

    public Compte() {
    }

    public void addClients(Client client) {
        this.clients.add(client);
    }

    public void deleteClients(Client client) {
        this.clients.remove(client);
    }

    public void updateCompte(Compte compteOld) {
    }

    public void retrait(Operation operation) {
        this.solde -= operation.getMontant();
        operation.setCompte(this);
        this.operations.add(operation);
    }
    public void virement(Operation operation) {
        this.solde += operation.getMontant();
        operation.setCompte(this);
        this.operations.add(operation);
    }
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }
}
