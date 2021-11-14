package banque.dao;

import banque.entity.compte.Compte;

public interface ICompteDao extends IDao<Compte> {
    public Compte findByNumero(String numero) ;
}
