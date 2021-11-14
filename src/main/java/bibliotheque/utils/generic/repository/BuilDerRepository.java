package bibliotheque.utils.generic.repository;

import bibliotheque.utils.connection.ConnectionDBibliotheque;

import javax.persistence.EntityManager;


/**
 * The Class BuilDerRepository.
 */
public abstract class BuilDerRepository {

    /**
     * Gets the entity manager.
     *
     * @return the entity manager
     */
    public EntityManager getEntityManager() {
        return ConnectionDBibliotheque.getInstance();
    }

}
