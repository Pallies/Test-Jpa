package bibliotheque.dao;

import bibliotheque.entity.Client;
import bibliotheque.entity.Livre;
import bibliotheque.utils.generic.IDaoImpl;

import java.util.Set;

/**
 * The Interface IClientDaoImpl.
 */
public interface IClientDaoImpl extends IDaoImpl<Client,Integer> {

    /**
     * Find emprunt by client.
     *
     * @param id the id
     * @return the sets the
     */
    public Set<Livre> findEmpruntByClient(Integer id);
}
