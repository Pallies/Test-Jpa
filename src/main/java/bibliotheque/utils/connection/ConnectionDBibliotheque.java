package bibliotheque.utils.connection;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ResourceBundle;

/**
 * The Class ConnectionDB.
 */
public final class ConnectionDBibliotheque {

    /**
     * The em.
     */
    private static EntityManager em;

    /**
     * The persistance.
     */
    private static String PERSISTANCE;

    {
        String data_file = "dataBase";
        String data_name = "DB_BIBLIOTHEQUE";
        ResourceBundle rb = ResourceBundle.getBundle(data_file);
        PERSISTANCE = rb.getString(data_name);
    }

    /**
     * Instantiates a new connection DB.
     */
    private ConnectionDBibliotheque() {
        em = Persistence.createEntityManagerFactory(PERSISTANCE).createEntityManager();
    }

    /**
     * Gets the single instance of ConnectionDB.
     *
     * @return single instance of ConnectionDB
     */
    public static EntityManager getInstance() {
        if (em == null || !em.isOpen())
            new ConnectionDBibliotheque();
        return em;
    }

    /**
     * Close the single instance of ConnectionDB.
     */
    public static void close() {
        if (em.isOpen())
            em.close();
    }
}
