package banque.utils;

import banque.entity.Banque;
import banque.repository.BanqueRepository;
import banque.repository.Repository;

public final class BuilderBanque {

    private BuilderBanque(){
    }

    public static Banque createBanque(String name){
        Banque banque = new Banque();
        banque.setNom(name);
        BanqueRepository repository = new BanqueRepository();
        repository.save(banque);
        return banque;
    }
}
