package banque.repository;

import banque.dao.ICompteDao;
import banque.dao.IOperationDao;
import banque.entity.compte.Compte;
import banque.entity.operation.Operation;

import static banque.enums.Transaction.*;

import java.util.List;


public class OperationRepository extends Repository implements IOperationDao {
    @Override
    public List<Operation> find() {
        return null;
    }

    @Override
    public Operation findById(int id) {
        return null;
    }

    @Override
    public void save(Operation operation) {
        transaction(PERSIST, operation);
    }

    @Override
    public void update(Operation operationOld, Operation operationNew) {

    }

    @Override
    public void update(Operation operation) {
        transaction(MERGE, operation);
    }

    @Override
    public void delete(Operation operation) {
        transaction(REMOVE, operation);
    }

    @Override
    public void assignOperationInCompte(Operation operation, Compte compte) {
        compte.addOperation(operation);
        save(operation);
    }
}
