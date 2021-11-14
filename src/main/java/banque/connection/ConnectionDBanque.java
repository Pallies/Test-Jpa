package banque.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ResourceBundle;

public final class ConnectionDBanque {

    private static EntityManager entityManager;
    private static String PERSISTANCE;
    {
        String data_file = "dataBase";
        String data_name = "DB_BANQUE";
        ResourceBundle persistence = ResourceBundle.getBundle(data_file);
        PERSISTANCE = persistence.getString(data_name);
    }

    private ConnectionDBanque(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTANCE);
        entityManager = emf.createEntityManager();
    }


    public static EntityManager getInstance(){
        if(entityManager == null || !entityManager.isOpen())
            new ConnectionDBanque();
        return entityManager;
    }


    public static void close() {
        if(entityManager.isOpen())
            entityManager.close();
    }
}
