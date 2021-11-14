package banque.entity;

import banque.entity.client.Client;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "BANQUE")
public class Banque implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BANK")
    private Integer id;

    @Column(name = "NOM",nullable = false)
    private String nom;

    @OneToMany(mappedBy = "banque")
    private Set<Client> clients = new HashSet<>();

    public Banque(){}

    public void addClient(Client client){
        client.addBanque(this);
        clients.add(client);
    }
    public void deleteClient(Client client){
        client.deleteBanque();
        client.deleteCompte();
        clients.remove(client);
    }
    public void update(Banque banqueOld){
        if (this.id ==null)
            setId(banqueOld.getId());
        if(this.nom == null)
            setNom(banqueOld.getNom());
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }
}
