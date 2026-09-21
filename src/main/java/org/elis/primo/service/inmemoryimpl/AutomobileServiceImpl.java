package org.elis.primo.service.inmemoryimpl;

import org.elis.primo.db.SingletonDb;
import org.elis.primo.model.Automobile;
import org.elis.primo.service.def.AutomobileService;

import java.util.List;

public class AutomobileServiceImpl implements AutomobileService {

    SingletonDb instance=SingletonDb.getInstance();

    @Override
    public long creaAutomobile(Automobile automobile) {
        if(automobile==null||automobile.getTarga()==null||
        automobile.getTarga().length()!=7
        ||instance.getAutomobili().stream()
                .map(Automobile::getTarga)
                .anyMatch(targaPresente->targaPresente
                        .equalsIgnoreCase(automobile.getTarga()))
        ){
            return 0;
        }
        return instance.aggiungiAutomobile(automobile);
    }

    @Override
    public Automobile rimuoviAutomobile(long id) {
        return null;
    }

    @Override
    public List<Automobile> getAll() {
        return List.of();
    }

    @Override
    public Automobile getAutomobile(long id) {
        return null;
    }

    @Override
    public Automobile getAutomobile(String targa) {
        return null;
    }
}
