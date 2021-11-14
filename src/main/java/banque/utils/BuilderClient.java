package banque.utils;

import banque.entity.client.Adresse;
import banque.entity.client.Client;
import banque.enums.Transaction;
import banque.repository.ClientRepository;
import banque.repository.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BuilderClient {

    private static final List<Client> CLIENTS = new ArrayList<>();

    private BuilderClient() {
    }

    public static List<Client> getClients() {
        createClient();
        ClientRepository repository = new ClientRepository();
        CLIENTS.forEach(repository::save);
        return CLIENTS;
    }

    private static void createClient() {
        Client client1 = new Client();
        client1.setNom("Fox");
        client1.setPrenom("Terry");
        client1.setDateNaissance(LocalDate.of(1958, 6, 28));
        client1.setAdresse(new Adresse("116", "Av. Ernest Ruben", 87000, "Limoges"));

        Client client2 = new Client();
        client2.setPrenom("Bobbie");
        client2.setNom("Rosenfeld");
        client2.setDateNaissance(LocalDate.of(1904, 11, 28));
        client2.setAdresse(new Adresse("11", "Rue Félix Brun", 69007, "Lyon"));

        Client client3 = new Client();
        client3.setPrenom("James");
        client3.setNom("Dean");
        client3.setDateNaissance(LocalDate.of(1931, 1, 8));
        client3.setAdresse(new Adresse("21", "impasse du moulin", 69007, "Nantes"));

        Client client4 = new Client();
        client4.setPrenom("James ");
        client4.setNom("Naismith");
        client4.setDateNaissance(LocalDate.of(1861, 10, 6));
        client4.setAdresse(new Adresse("67B", "Rue Guillaume Apollinaire", 25000, "Besançon"));

        Client client5 = new Client();
        client5.setPrenom("Bobbie");
        client5.setNom("Rosenfeld");
        client5.setDateNaissance(LocalDate.of(1904, 11, 28));
        client5.setAdresse(new Adresse("93", "Rue Charles III", 54000, "Nancy"));

        CLIENTS.add(client1);
        CLIENTS.add(client2);
        CLIENTS.add(client3);
        CLIENTS.add(client4);
        CLIENTS.add(client5);
    }
}
