package bibliotheque.run;

import banque.connection.ConnectionDBanque;
import bibliotheque.utils.connection.ConnectionDBibliotheque;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ResourceBundle;


public class TestTp1 {

    private static final Logger LOGGER = LoggerFactory.getLogger("runTestJpa");
    private static String PERSISTENCE;
    {
        ResourceBundle db_file = ResourceBundle.getBundle("dataBase");
        PERSISTENCE = db_file.getString("DB_BIBLIOTHEQUE");
    }
    /**
     * exercices tp 1
     * création d'une connexion à la base de donnée
     */
    public static void main(String[] args) {
//        ConnectionDBanque.close();
//        ConnectionDBibliotheque.close();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        LOGGER.trace("entityManager {}", entityManager);
        entityManager.close();
    }
}
