package bibliotheque.dao;

import bibliotheque.entity.Client;
import bibliotheque.entity.Emprunt;
import bibliotheque.entity.Livre;
import bibliotheque.utils.generic.IDao;


import java.util.Set;


/**
 * The Interface IEmpruntDao.
 */
public interface IEmpruntDao extends IDao<Emprunt,Integer> {

    /**
     * Find by client.
     *
     * @param client the client
     * @return the sets the
     */
    public Set<Livre> findByClient(Client client);
    
    /**
     * Find by emprunt.
     *
     * @param emprunt the emprunt
     * @return the sets the
     */
    public Set<Livre> findByEmprunt(Emprunt emprunt);
}
