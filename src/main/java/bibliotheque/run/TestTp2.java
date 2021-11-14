package bibliotheque.run;

import bibliotheque.utils.connection.ConnectionDBibliotheque;
import bibliotheque.service.LivreService;
import bibliotheque.dao.ILivreDaoImpl;
import bibliotheque.entity.Livre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TestTp2 {

    private static final Logger LOGGER = LoggerFactory.getLogger("runTestJpa");

    public static void main(String[] args) {
        /**
         * exercices tp 2
         *
         */
        ILivreDaoImpl livreRepository = new LivreService();

        Livre isDelete = livreRepository.findById(2);
        if(isDelete == null){
            Livre livreDelete = new Livre(2, "Germinal", "Emile Zola");
            livreRepository.save(livreDelete);
        }

        Livre livre = livreRepository.findById(2);
        LOGGER.trace("Le livre  avec l'id {} a été réinséré \n", livre.getId());

        Livre livreByTitle = livreRepository.findByTitle("1001 recettes de Cuisine");
        LOGGER.trace("livre qui correspond au titre 1001 recettes de Cuisine : {}\n", livreByTitle);

        Livre livreByAuth = livreRepository.findByAuth("Léon Tolstoï");
        LOGGER.trace("livre de l'auteur Léon Tolstoï -> {}\n", livreByAuth);

        livreRepository.delete(livre);
        List<Livre> livres = livreRepository.find();
        for (Livre l : livres) {
            LOGGER.trace("livre n° {} de la BDD de l'auteur : {} et qui a pour titre \" {} \" ", l.getId(), l.getAuteur(), l.getTitre());
        }
        ConnectionDBibliotheque.close();
    }
}
