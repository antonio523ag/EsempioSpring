package org.elis.primo.service.jpaimpl;

import lombok.RequiredArgsConstructor;
import org.elis.primo.model.Automobile;
import org.elis.primo.repository.AutomobileRepository;
import org.elis.primo.service.def.AutomobileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AutomobileServiceImpl implements AutomobileService {

    private final AutomobileRepository repo;

    @Override
    public long creaAutomobile(Automobile automobile) {
        Automobile aut = repo.save(automobile);
        return aut.getId();
    }

    @Override
    public Automobile rimuoviAutomobile(long id) {
        Automobile a=getAutomobile(id);
        if(a==null){
            return null;
        }
        repo.delete(a);
        return a;
    }

    @Override
    public List<Automobile> getAll() {
        return repo.findAll();
    }

    @Override
    public Automobile getAutomobile(long id) {
        Optional<Automobile> opt=repo.findById(id);
//        if(opt.isPresent()){
//            return opt.get();
//        }else{
//            return null;
//        }
//        if(opt.isEmpty()){
//            return null;
//        }else{
//            return opt.get();
//        }

        return opt.orElse(null);
    }

    @Override
    public Automobile getAutomobile(String targa) {
        return repo.trovaByTarga(targa).orElse(null);
    }
}
