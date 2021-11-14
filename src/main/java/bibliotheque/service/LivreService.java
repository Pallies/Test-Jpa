package bibliotheque.service;

import bibliotheque.dao.IEmpruntDao;
import bibliotheque.dao.ILivreDao;
import bibliotheque.dao.ILivreDaoImpl;
import bibliotheque.entity.Emprunt;
import bibliotheque.entity.Livre;
import bibliotheque.repository.EmpruntRepository;
import bibliotheque.repository.LivreRepository;

import java.util.List;
import java.util.Set;

/**
 * The Class LivreService.
 */
public class LivreService implements ILivreDaoImpl {

    /** The repository. */
    private final ILivreDao repository;
    
    /** The emprunt repository. */
    private final IEmpruntDao empruntRepository;

    {
        repository = new LivreRepository();
        empruntRepository = new EmpruntRepository();
    }

    /**
     * Find.
     *
     * @return the list
     */
    @Override
    public List<Livre> find() {
        return repository.find();
    }

    /**
     * Find by id.
     *
     * @param livre the livre
     * @return the livre
     */
    @Override
    public Livre findById(Livre livre) {
        return repository.findById(livre.getId());
    }

    /**
     * Find by id.
     *
     * @param id the id
     * @return the livre
     */
    @Override
    public Livre findById(Integer id) {
        return repository.findById(id);
    }

    /**
     * Find by auth.
     *
     * @param livre the livre
     * @return the livre
     */
    @Override
    public Livre findByAuth(Livre livre) {
        return repository.findByAuth(livre.getAuteur());
    }

    /**
     * Find by auth.
     *
     * @param auteur the auteur
     * @return the livre
     */
    @Override
    public Livre findByAuth(String auteur) {
        return repository.findByAuth(auteur);
    }

    /**
     * Find by title.
     *
     * @param livre the livre
     * @return the livre
     */
    @Override
    public Livre findByTitle(Livre livre) {
        return repository.findByTitle(livre.getTitre());
    }

    /**
     * Find by title.
     *
     * @param titre the titre
     * @return the livre
     */
    @Override
    public Livre findByTitle(String titre) {
        return repository.findByTitle(titre);
    }

    /**
     * Find by emprunt.
     *
     * @param id the id
     * @return the sets the
     */
    @Override
    public Set<Livre> findByEmprunt(Integer id) {
        Emprunt emprunt = empruntRepository.findById(id);
        return empruntRepository.findByEmprunt(emprunt);
    }

    /**
     * Save.
     *
     * @param livre the livre
     * @return true, if successful
     */
    @Override
    public boolean save(Livre livre) {
        repository.save(livre);
        return repository.find().contains(livre);
    }

    /**
     * Update.
     *
     * @param livreOld the livre old
     * @param livreNew the livre new
     * @return true, if successful
     */
    @Override
    public boolean update(Livre livreOld, Livre livreNew) {
        repository.update(livreOld, livreNew);
        return repository.find().contains(livreNew);
    }

    /**
     * Delete.
     *
     * @param livre the livre
     * @return true, if successful
     */
    @Override
    public boolean delete(Livre livre) {
        repository.delete(livre);
        return !repository.find().contains(livre);
    }


}
