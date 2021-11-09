package Bibliotheque.repository;

import Bibliotheque.dao.IClientDao;
import Bibliotheque.entity.Client;
import Bibliotheque.utils.generic.repository.BuilDerRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * The Class ClientRepository.
 */
public class ClientRepository extends BuilDerRepository implements IClientDao {


    /**
     * Find.
     *
     * @return the list
     */
    @Override
    public List<Client> find() {
        return getEntityManager()
                .createQuery("SELECT c FROM Client as c", Client.class)
                .getResultList();
    }

    /**
     * Find by id.
     *
     * @param id the id
     * @return the client
     */
    @Override
    public Client findById(Integer id) {
        TypedQuery<Client> qry = getEntityManager()
                .createQuery("SELECT c FROM Client as c WHERE c.id= :id", Client.class);
        qry.setParameter("id", id);
        return qry.getSingleResult();
    }

    /**
     * Find by client.
     *
     * @param client the client
     * @return the client
     */
    @Override
    public Client findByClient(Client client) {
        TypedQuery<Client> qry = getEntityManager()
                .createQuery("SELECT c FROM Client as c WHERE c.nom= :nom AND c.prenom= :prenom", Client.class);
        return qry.getSingleResult();
    }

    /**
     * Save.
     *
     * @param client the client
     */
    @Override
    public void save(Client client) {
        if (findByClient(client).getId() != null) {
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            em.persist(client);
            em.getTransaction().commit();
        }
    }

    /**
     * Update.
     *
     * @param clientOld the client old
     * @param clientNew the client new
     */
    @Override
    public void update(Client clientOld, Client clientNew) {
        Client clientRef = findByClient(clientOld);
        if (clientRef != null) {
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            clientRef.setClient(clientNew);
            em.getTransaction().commit();
        }
    }

    /**
     * Delete.
     *
     * @param client the client
     */
    @Override
    public void delete(Client client) {
        Client clientRef = findByClient(client);
        if (clientRef != null) {
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            em.remove(clientRef);
            em.getTransaction().commit();
        }
    }
}
