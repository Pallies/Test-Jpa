package banque.entity.compte;

import banque.entity.client.Client;
import banque.entity.operation.Operation;
import banque.entity.operation.Retrait;
import banque.entity.operation.Virement;

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

    public void addOperation(Operation operation) {
        operations.add(operation);
        if (operation instanceof Virement) {
            this.solde += operation.getMontant();
        } else if (operation instanceof Retrait) {
            this.solde -= operation.getMontant();
        }else{
            this.solde += operation.getMontant();
        }
        operation.setCompte(this);
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
