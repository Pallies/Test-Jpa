package Bibliotheque.utils.generic;

import java.util.List;

/**
 * The Interface IDaoImpl.
 *
 * @param <T> the generic type
 * @param <U> the generic type
 */
public interface IDaoImpl<T,U> {

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
     * @return true, if successful
     */
    public boolean save(T object);
    
    /**
     * Update.
     *
     * @param objectOld the object old
     * @param objectNew the object new
     * @return true, if successful
     */
    public boolean update(T objectOld,T objectNew);
    
    /**
     * Delete.
     *
     * @param object the object
     * @return true, if successful
     */
    public boolean delete(T object);
}
