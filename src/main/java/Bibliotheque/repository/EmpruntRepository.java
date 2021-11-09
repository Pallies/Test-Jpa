package Bibliotheque.repository;

import Bibliotheque.entity.Client;
import Bibliotheque.dao.IEmpruntDao;
import Bibliotheque.entity.Emprunt;
import Bibliotheque.entity.Livre;
import Bibliotheque.utils.generic.repository.BuilDerRepository;

import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The Class EmpruntRepository.
 */
public class EmpruntRepository extends BuilDerRepository implements IEmpruntDao {

    /**
     * Find.
     *
     * @return the list
     */
    @Override
    public List<Emprunt> find() {
        return getEntityManager()
                .createQuery("SELECT e FROM Emprunt as e", Emprunt.class)
                .getResultList();
    }

    /**
     * Find by id.
     *
     * @param id the id
     * @return the emprunt
     */
    @Override
    public Emprunt findById(Integer id) {
        TypedQuery<Emprunt> qry = getEntityManager()
                .createQuery("SELECT e FROM Emprunt as e WHERE e.id= :id", Emprunt.class);
        qry.setParameter("id", id);
        return qry.getSingleResult();
    }

    /**
     * Find by client.
     *
     * @param client the client
     * @return the sets the
     */
    @Override
    public Set<Livre> findByClient(Client client) {
        TypedQuery<Emprunt> listEmprumtClient = getEntityManager().createQuery("SELECT e FROM Emprunt as e WHERE e.client= :client", Emprunt.class);
        listEmprumtClient.setParameter("client", client);
        return listEmprumtClient.getResultList()
                .stream()
                .map(Emprunt::getLivres)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    /**
     * Find by emprunt.
     *
     * @param emprunt the emprunt
     * @return the sets the
     */
    @Override
    public Set<Livre> findByEmprunt(Emprunt emprunt) {
        TypedQuery<Emprunt> qry = getEntityManager().createQuery("SELECT l FROM Emprunt as l WHERE l.id= :id", Emprunt.class);
        qry.setParameter("id", emprunt.getId());
        return qry.getResultList()
                .stream().map(Emprunt::getLivres)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    /**
     * Save.
     *
     * @param emprunt the emprunt
     */
    @Override
    public void save(Emprunt emprunt) {

    }

    /**
     * Update.
     *
     * @param emprunt0ld the emprunt 0 ld
     * @param empruntNew the emprunt new
     */
    @Override
    public void update(Emprunt emprunt0ld, Emprunt empruntNew) {

    }

    /**
     * Delete.
     *
     * @param emprunt the emprunt
     */
    @Override
    public void delete(Emprunt emprunt) {

    }
}
