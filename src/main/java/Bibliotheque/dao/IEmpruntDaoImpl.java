package Bibliotheque.dao;

import Bibliotheque.entity.Client;
import Bibliotheque.entity.Emprunt;
import Bibliotheque.entity.Livre;
import Bibliotheque.utils.generic.IDaoImpl;

import java.util.Set;


/**
 * The Interface IEmpruntDaoImpl.
 */
public interface IEmpruntDaoImpl extends IDaoImpl<Emprunt,Integer> {
    
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
