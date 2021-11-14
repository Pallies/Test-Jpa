package banque.repository;

import banque.dao.IDao;
import banque.entity.client.Client;

import javax.persistence.TypedQuery;
import java.util.List;
import static banque.enums.Transaction.*;

public class ClientRepository extends Repository implements IDao<Client> {
    @Override
    public List<Client> find() {
        TypedQuery<Client> qry = getEntityManger()
                .createQuery("SELECT c FROM Client as c", Client.class);
        return qry.getResultList();
    }

    @Override
    public Client findById(int id) {
        TypedQuery<Client> qry =getEntityManger()
                .createQuery("SELECT c FROM Client as c WHERE c.id= :id",Client.class);
        qry.setParameter("id",id);
        return qry.getSingleResult();
    }

    @Override
    public void save(Client client) {
        transaction(PERSIST,client);
    }

    @Override
    public void update(Client clientOld, Client clientNew) {
       clientNew.update(clientOld);
       update(clientNew);
    }

    @Override
    public void update(Client client) {
        transaction(MERGE,client);
    }

    @Override
    public void delete(Client client) {
        transaction(REMOVE,client);
    }
}
