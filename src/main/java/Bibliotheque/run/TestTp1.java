package Bibliotheque.run;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TestTp1 {

    private static final Logger LOGGER = LoggerFactory.getLogger("runTestJpa");

    public static void main(String[] args) {
        /**
         * exercices tp 1
         * création d'une connexion à la base de donnée
         */
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test-jpa-connection");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        LOGGER.trace("entityManager {}", entityManager);
    }
}
