package bibliotheque.utils.generic;

import java.util.List;

/**
 * The Interface IDao.
 *
 * @param <T> the generic type
 * @param <U> the generic type
 */
public interface IDao<T,U> {

    /**
     * Find.
     *
     * @return the list
     */
    public List<T> find();
    
    /**
     * Find by id.
     *
     * @param id the id
     * @return the t
     */
    public T findById(U id);
    
    /**
     * Save.
     *
     * @param object the object
     */
    public void save(T object);
    
    /**
     * Update.
     *
     * @param objectOld the object old
     * @param objectNew the object new
     */
    public void update(T objectOld,T objectNew);
    
    /**
     * Delete.
     *
     * @param object the object
     */
    public void delete(T object);
}
