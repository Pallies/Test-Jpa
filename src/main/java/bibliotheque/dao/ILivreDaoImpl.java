package bibliotheque.dao;


import bibliotheque.entity.Livre;
import bibliotheque.utils.generic.IDaoImpl;
import java.util.Set;

/**
 * The Interface ILivreDaoImpl.
 */
public interface ILivreDaoImpl extends IDaoImpl<Livre,Integer> {

    /**
     * Find by id.
     *
     * @param livre the livre
     * @return the livre
     */
    public Livre findById(Livre livre);
    
    /**
     * Find by auth.
     *
     * @param livre the livre
     * @return the livre
     */
    public Livre findByAuth(Livre livre);
    
    /**
     * Find by title.
     *
     * @param livre the livre
     * @return the livre
     */
    public Livre findByTitle(Livre livre);
    
    /**
     * Find by auth.
     *
     * @param auteur the auteur
     * @return the livre
     */
    public Livre findByAuth(String auteur);
    
    /**
     * Find by title.
     *
     * @param titre the titre
     * @return the livre
     */
    public Livre findByTitle(String titre);
    
    /**
     * Find by emprunt.
     *
     * @param id the id
     * @return the sets the
     */
    public Set<Livre> findByEmprunt(Integer id);

}
