package bibliotheque.service;

import bibliotheque.entity.Client;
import bibliotheque.dao.IEmpruntDao;
import bibliotheque.dao.IEmpruntDaoImpl;
import bibliotheque.entity.Emprunt;
import bibliotheque.entity.Livre;
import bibliotheque.repository.EmpruntRepository;

import java.util.List;
import java.util.Set;

/**
 * The Class EmpruntService.
 */
public class EmpruntService implements IEmpruntDaoImpl {

    /** The repository. */
    private final IEmpruntDao repository;

    {
        repository = new EmpruntRepository();
    }

    /**
     * Find.
     *
     * @return the list
     */
    @Override
    public List<Emprunt> find() {
        return repository.find();
    }

    /**
     * Find by id.
     *
     * @param id the id
     * @return the emprunt
     */
    @Override
    public Emprunt findById(Integer id) {
        return repository.findById(id);
    }

    /**
     * Find by client.
     *
     * @param client the client
     * @return the sets the
     */
    @Override
    public Set<Livre> findByClient(Client client) {
        return repository.findByClient(client);
    }

    /**
     * Find by emprunt.
     *
     * @param emprunt the emprunt
     * @return the sets the
     */
    public Set<Livre> findByEmprunt(Emprunt emprunt) {
        return repository.findByEmprunt(emprunt);
    }

    /**
     * Save.
     *
     * @param emprunt the emprunt
     * @return true, if successful
     */
    @Override
    public boolean save(Emprunt emprunt) {
        repository.save(emprunt);
        return repository.find().contains(emprunt);
    }

    /**
     * Update.
     *
     * @param empruntOld the emprunt old
     * @param empruntNew the emprunt new
     * @return true, if successful
     */
    @Override
    public boolean update(Emprunt empruntOld, Emprunt empruntNew) {
        repository.update(empruntOld, empruntNew);
        return repository.find().contains(empruntNew);
    }

    /**
     * Delete.
     *
     * @param emprunt the emprunt
     * @return true, if successful
     */
    @Override
    public boolean delete(Emprunt emprunt) {
        repository.delete(emprunt);
        return !repository.find().contains(emprunt);
    }
}
