package Bibliotheque.utils.generic.repository;

import Bibliotheque.utils.connection.ConnectionDB;

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
        return ConnectionDB.getInstance();
    }

}
