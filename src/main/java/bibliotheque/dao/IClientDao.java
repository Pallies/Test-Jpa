package bibliotheque.dao;

import bibliotheque.entity.Client;
import bibliotheque.utils.generic.IDao;

/**
 * The Interface IClientDao.
 */
public interface IClientDao extends IDao<Client, Integer> {

    /**
     * Find by client.
     *
     * @param client the client
     * @return the client
     */
    public Client findByClient(Client client);
}
