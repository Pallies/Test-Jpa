package bibliotheque.dao;

import bibliotheque.entity.Client;
import bibliotheque.entity.Emprunt;
import bibliotheque.entity.Livre;
import bibliotheque.utils.generic.IDaoImpl;

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
