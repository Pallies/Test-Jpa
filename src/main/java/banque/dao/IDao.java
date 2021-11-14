package banque.dao;

import java.util.List;

public interface IDao<T> {

    public List<T> find();

    public T findById(int id);

    public void save(T object);

    public void update(T objectOld,T objectNew);

    public void update(T object);

    public void delete(T object);
}
