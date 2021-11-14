package bibliotheque.service;

import bibliotheque.dao.IClientDao;
import bibliotheque.dao.IClientDaoImpl;
import bibliotheque.entity.Client;
import bibliotheque.dao.IEmpruntDao;
import bibliotheque.entity.Livre;
import bibliotheque.repository.ClientRepository;
import bibliotheque.repository.EmpruntRepository;

import java.util.List;
import java.util.Set;

/**
 * The Class ClientService.
 */
public class ClientService implements IClientDaoImpl {

    /** The repository. */
    private final IClientDao repository;
    
    /** The emprunt repository. */
    private final IEmpruntDao empruntRepository;

    {
        repository = new ClientRepository();
        empruntRepository = new EmpruntRepository();
    }

    /**
     * Find.
     *
     * @return the list
     */
    @Override
    public List<Client> find() {
        return repository.find();
    }

    /**
     * Find by id.
     *
     * @param id the id
     * @return the client
     */
    @Override
    public Client findById(Integer id) {
        return repository.findById(id);
    }

    /**
     * Find emprunt by client.
     *
     * @param id the id
     * @return the sets the
     */
    @Override
    public Set<Livre> findEmpruntByClient(Integer id) {
        Client client = repository.findById(id);
        return empruntRepository.findByClient(client);
    }

    /**
     * Save.
     *
     * @param client the client
     * @return true, if successful
     */
    @Override
    public boolean save(Client client) {
        repository.save(client);
        return find().contains(client);
    }

    /**
     * Update.
     *
     * @param clientOld the client old
     * @param clientNew the client new
     * @return true, if successful
     */
    @Override
    public boolean update(Client clientOld, Client clientNew) {
        repository.update(clientOld, clientNew);
        return find().contains(clientNew);
    }

    /**
     * Delete.
     *
     * @param client the client
     * @return true, if successful
     */
    @Override
    public boolean delete(Client client) {
        repository.delete(client);
        return find().contains(client);
    }
}
