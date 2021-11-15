package banque.run;

import banque.dao.IOperationDao;
import banque.entity.Banque;
import banque.entity.client.Client;
import banque.entity.compte.AssuranceVie;
import banque.entity.compte.Compte;
import banque.entity.compte.LivretA;
import banque.entity.operation.Operation;
import banque.entity.operation.Virement;
import banque.repository.OperationRepository;
import banque.utils.BuilderBanque;
import banque.utils.BuilderClient;
import banque.utils.BuilderCompte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;




public class TestTp4Tp5 {

    private static final Logger LOGGER = LoggerFactory.getLogger("runTestJpa");

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
        Operation operation1=new Operation( LocalDate.now(),1687.89,"PAYE");
        Operation operation2=new Operation( LocalDate.now(),2687.89,"PAYE");
        Operation operation3=new Operation( LocalDate.now(),3687.89,"PAYE");
        Operation virement1 = new Virement(LocalDate.now(),687.89,"RETRAITE",clients.get(1).getNom());
        Operation virement2 = new Virement(LocalDate.now(),87.89,"PREVOYANCE",clients.get(2).getNom());
        Operation virement3 = new Virement(LocalDate.now(),1687.89,"RETRAITE",clients.get(3).getNom());

        IOperationDao repository = new OperationRepository();

        LOGGER.trace("etat du compte : {}",livretA.get(0).getSolde());
        /// OPERATION
        repository.assignOperationInCompte(operation1,livretA.get(0));
        repository.assignOperationInCompte(operation2,livretA.get(1));
        repository.assignOperationInCompte(operation3,livretA.get(2));
        /// VIREMENT
        repository.assignOperationInCompte(virement1,assuranceVie.get(0));
        repository.assignOperationInCompte(virement2,assuranceVie.get(1));
        repository.assignOperationInCompte(virement3,assuranceVie.get(2));
        LOGGER.trace("etat du compte : {} , après opération",livretA.get(0).getSolde());
    }
}
