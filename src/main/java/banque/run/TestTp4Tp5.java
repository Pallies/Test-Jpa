package banque.run;

import banque.dao.IOperationDao;
import banque.entity.Banque;
import banque.entity.client.Client;
import banque.entity.compte.AssuranceVie;
import banque.entity.compte.Compte;
import banque.entity.compte.LivretA;
import banque.repository.OperationRepository;
import banque.utils.BuilderBanque;
import banque.utils.BuilderClient;
import banque.utils.BuilderCompte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;




public class TestTp4Tp5 {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestTp4Tp5.class);

    public static void main(String[] args) {
        Banque banque = BuilderBanque.createBanque("LA BANQUE POSTALE");

        List<Client> clients = BuilderClient.getClients();
        List<Compte> comptes = BuilderCompte.getComptes();

        List<Compte> livretA  = comptes.stream().filter(c->c instanceof LivretA).collect(Collectors.toList());
        List<Compte> assuranceVie  = comptes.stream().filter(c->c instanceof AssuranceVie).collect(Collectors.toList());
//        inscription des clients à la banque
        clients.forEach(banque::addClient);
//        affectation d'un livretA
        clients.get(0).addCompte(livretA.get(0));
        clients.get(1).addCompte(livretA.get(0));
        clients.get(0).addCompte(assuranceVie.get(0));
        clients.get(1).addCompte(assuranceVie.get(1));

        //////
        clients.get(2).addCompte(livretA.get(1));
        clients.get(2).addCompte(livretA.get(2));
        clients.get(2).addCompte(assuranceVie.get(2));
        /////
        clients.get(3).addCompte(livretA.get(3));
        clients.get(3).addCompte(assuranceVie.get(3));
        clients.get(3).addCompte(assuranceVie.get(2));
        ///// operation virement livretA
        IOperationDao operationCompte=new OperationRepository();
//        Operation operation=new Virement( LocalDate.now(),1687.89,"PAYE",clients.get(0).getNom());
//        operationCompte.save(operation);
//        Compte livretAClient1 = clients.get(0).getComptes().stream().filter(c->c instanceof LivretA).collect(Collectors.toList()).get(0);
//        operationCompte.assignOperationInCompte(operation,livretAClient1, VIREMENT);
        LOGGER.trace("aperçu de la connexion : {}");
    }
}
