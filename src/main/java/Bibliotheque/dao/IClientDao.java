package Bibliotheque.dao;

import Bibliotheque.entity.Client;
import Bibliotheque.utils.generic.IDao;

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
