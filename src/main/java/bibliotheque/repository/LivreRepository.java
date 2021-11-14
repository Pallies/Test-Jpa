package bibliotheque.repository;


import bibliotheque.entity.Livre;
import bibliotheque.dao.ILivreDao;
import bibliotheque.utils.generic.repository.BuilDerRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * The Class LivreRepository.
 */
public class LivreRepository extends BuilDerRepository implements ILivreDao {

    /**
     * Find.
     *
     * @return the list
     */
    @Override
    public List<Livre> find() {
        return getEntityManager()
                .createQuery("SELECT l FROM Livre as l", Livre.class)
                .getResultList();
    }

    /**
     * Find by id.
     *
     * @param id the id
     * @return the livre
     */
    @Override
    public Livre findById(Integer id) {
        TypedQuery<Livre> qry = getEntityManager()
                .createQuery("SELECT l FROM Livre as l WHERE l.id= :id", Livre.class);
        qry.setParameter("id", id);
        return qry.getResultList().isEmpty() ? null : qry.getSingleResult();

    }

    /**
     * Find by auth.
     *
     * @param auteur the auteur
     * @return the livre
     */
    @Override
    public Livre findByAuth(String auteur) {
        TypedQuery<Livre> qry = getEntityManager()
                .createQuery("SELECT l FROM Livre as l WHERE l.auteur= :auteur", Livre.class);
        qry.setParameter("auteur", auteur);
        return qry.getResultList().isEmpty() ? null : qry.getSingleResult();
    }

    /**
     * Find by title.
     *
     * @param titre the titre
     * @return the livre
     */
    @Override
    public Livre findByTitle(String titre) {
        TypedQuery<Livre> qry = getEntityManager()
                .createQuery("SELECT l FROM Livre as l WHERE l.titre= :titre", Livre.class);
        qry.setParameter("titre", titre);
        return qry.getResultList().isEmpty() ? null : qry.getSingleResult();
    }

    /**
     * Save.
     *
     * @param livre the livre
     */
    @Override
    public void save(Livre livre) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(livre);
        em.getTransaction().commit();
    }

    /**
     * Update.
     *
     * @param livreOld the livre old
     * @param livreNew the livre new
     */
    @Override
    public void update(Livre livreOld, Livre livreNew) {
        Livre livreRef = findByTitle(livreOld.getTitre());
        if (livreRef != null) {
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            livreRef.SetLivre(livreNew);
            em.getTransaction().commit();
        }
    }

    /**
     * Delete.
     *
     * @param livre the livre
     */
    @Override
    public void delete(Livre livre) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(livre);
        em.getTransaction().commit();
    }
}
