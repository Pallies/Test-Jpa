package banque.repository;

import banque.connection.ConnectionDBanque;
import banque.entity.operation.Operation;
import banque.enums.Transaction;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class Repository {
    /**
     * Gets the entity manger.
     *
     * @return the entity manger
     */
    public EntityManager getEntityManger() {
        return ConnectionDBanque.getInstance();
    }

    /**
     * Gets the transaction.
     *
     * @param <T> the generic type
     * @param name the Transaction
     * @param object the object
     */
    public <T> void transaction(Transaction name, T object) {
        EntityManager em = ConnectionDBanque.getInstance();
        em.getTransaction().begin();
        switch (name) {
            case MERGE:
                em.merge(object);
                break;
            case PERSIST:
                em.persist(object);
                break;
            case REMOVE:
                em.remove(object);
                break;
        }
        em.getTransaction().commit();
    }
}
