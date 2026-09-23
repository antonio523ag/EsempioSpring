package org.elis.primo.service.def;

import org.elis.primo.dto.response.AutomobileDTO;
import org.elis.primo.model.Automobile;

import java.util.List;

public interface AutomobileService {

    long creaAutomobile(Automobile automobile);
    Automobile rimuoviAutomobile(long id);
    List<AutomobileDTO> getAll();
    Automobile getAutomobile(long id);
    Automobile getAutomobile(String targa);

}
