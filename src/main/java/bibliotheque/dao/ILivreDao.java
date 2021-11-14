package bibliotheque.dao;

import bibliotheque.entity.Livre;
import bibliotheque.utils.generic.IDao;

/**
 * The Interface ILivreDao.
 */
public interface ILivreDao extends IDao<Livre,Integer> {

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
     * @param title the title
     * @return the livre
     */
    public Livre findByTitle(String title);
}
