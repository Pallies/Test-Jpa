package banque.dao;

import banque.entity.compte.Compte;
import banque.entity.operation.Operation;

public interface IOperationDao extends IDao<Operation>{
    public void assignOperationInCompte(Operation operation, Compte compte);
}
