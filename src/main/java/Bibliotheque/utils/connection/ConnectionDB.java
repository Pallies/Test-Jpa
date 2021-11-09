package Bibliotheque.utils.connection;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ResourceBundle;

/**
 * The Class ConnectionDB.
 */
public final class ConnectionDB {

    /** The em. */
    private static EntityManager em;
    
    /** The persistance. */
    private static String PERSISTANCE;

    {
        ResourceBundle rb = ResourceBundle.getBundle("dataBase");
        PERSISTANCE = rb.getString("DB");
    }

    /**
     * Instantiates a new connection DB.
     */
    private ConnectionDB() {
        em = Persistence.createEntityManagerFactory(PERSISTANCE).createEntityManager();
    }

    /**
     * Gets the single instance of ConnectionDB.
     *
     * @return single instance of ConnectionDB
     */
    public static EntityManager getInstance() {
        if (em == null || !em.isOpen())
            new ConnectionDB();
        return em;
    }
}
