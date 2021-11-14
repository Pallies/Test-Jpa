package banque.repository;

import banque.dao.ICompteDao;
import banque.entity.compte.Compte;

import javax.persistence.TypedQuery;
import java.util.List;

import static banque.enums.Transaction.*;

public class CompteRepository extends Repository implements ICompteDao {
    @Override
    public List<Compte> find() {
        return getEntityManger()
                .createQuery("SELECT c FROM Compte as c", Compte.class)
                .getResultList();
    }
    @Override
    public Compte findById(int id) {
        TypedQuery<Compte> qry = getEntityManger()
                .createQuery("SELECT c FROM Compte as c WHERE c.id= :id", Compte.class);
        qry.setParameter("id", id);
        return qry.getSingleResult();
    }

    public Compte findByNumero(String numero) {
        TypedQuery<Compte> qry = getEntityManger()
                .createQuery("SELECT c FROM Compte as c WHERE c.numero= :numero", Compte.class);
        qry.setParameter("numero", numero);
        return qry.getSingleResult();
    }
    @Override
    public void save(Compte compte) {
        transaction(PERSIST, compte);
    }

    @Override
    public void update(Compte compteOld, Compte compteNew) {
        compteNew.updateCompte(compteOld);
        update(compteNew);
    }

    @Override
    public void update(Compte compte) {
        transaction(MERGE, compte);
    }

    @Override
    public void delete(Compte compte) {
        transaction(REMOVE, compte);
    }
}
