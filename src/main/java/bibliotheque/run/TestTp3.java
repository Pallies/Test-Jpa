package bibliotheque.run;

import bibliotheque.dao.ILivreDaoImpl;
import bibliotheque.service.ClientService;
import bibliotheque.dao.IClientDaoImpl;
import bibliotheque.entity.Livre;
import bibliotheque.utils.connection.ConnectionDBibliotheque;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import bibliotheque.service.LivreService;

import java.util.Set;


public class TestTp3 {

    private static final Logger LOGGER = LoggerFactory.getLogger("runTestJpa");

    public static void main(String[] args) {


        /** exercices tp 3 ...*/
        ILivreDaoImpl livreService = new LivreService();
        Integer empruntId = 4;
        Set<Livre> livresEmprunt = livreService.findByEmprunt(empruntId);
        LOGGER.trace("tous les Livres emprunté par l'emprunt n° {} \n ", empruntId);
        for (Livre l : livresEmprunt) {
            LOGGER.trace(" le livre : {} \n", l.getTitre());
        }

        IClientDaoImpl clientService = new ClientService();
        Integer clientId = 3;
        Set<Livre> livresClient = clientService.findEmpruntByClient(clientId);

        for (Livre l : livresClient) {
            LOGGER.trace("Livre emprunté par le client n° {} \n est le livre : {}", clientId, l.getTitre());
        }
        ConnectionDBibliotheque.close();
    }
}
