package banque.repository;

import banque.dao.IDao;
import banque.entity.Banque;
import static banque.enums.Transaction.*;

import javax.persistence.TypedQuery;
import java.util.List;

public class BanqueRepository extends Repository implements IDao<Banque> {
    @Override
    public List<Banque> find() {
        return getEntityManger()
                .createQuery("SELECT b FROM Banque as b", Banque.class)
                .getResultList();
    }

    @Override
    public Banque findById(int id) {
        TypedQuery<Banque> qry = getEntityManger()
                .createQuery("SELECT b FROM Banque as b WHERE b.id= :id", Banque.class);
        qry.setParameter("id", id);
        return qry.getSingleResult();
    }

    @Override
    public void save(Banque banque) {
        transaction(PERSIST, banque);
    }

    @Override
    public void update(Banque banqueOld, Banque banqueNew) {
        banqueNew.update(banqueOld);
        update(banqueNew);
    }

    @Override
    public void update(Banque banque) {
        transaction(MERGE, banque);
    }

    @Override
    public void delete(Banque banque) {
        transaction(REMOVE, banque);
    }
}
