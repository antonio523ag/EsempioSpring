package org.elis.primo.facade.def;

import org.elis.primo.dto.request.CreaAutomobileDTO;
import org.elis.primo.dto.response.AutomobileDTO;

public interface AutomobileFacade {
    void assegna(long idAutomobile,long idPersona);

    AutomobileDTO creaAutomobile(CreaAutomobileDTO automobile);

}
