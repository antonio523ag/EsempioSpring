package org.elis.primo.facade.impl;

import lombok.RequiredArgsConstructor;
import org.elis.primo.dto.request.CreaAutomobileDTO;
import org.elis.primo.dto.response.AutomobileDTO;
import org.elis.primo.facade.def.AutomobileFacade;
import org.elis.primo.mapper.AutomobileMapper;
import org.elis.primo.model.Automobile;
import org.elis.primo.model.Persona;
import org.elis.primo.service.def.AutomobileService;
import org.elis.primo.service.def.PersonaService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutomobileFacadeImpl implements AutomobileFacade {
    private final PersonaService personaService;
    private final AutomobileService automobileService;
    private final AutomobileMapper automobileMapper;

    @Override
    public void assegna(long idAutomobile, long idPersona) {
        Persona p=personaService.getById(idPersona);
        if(p==null)return;
        Automobile a=automobileService.getAutomobile(idAutomobile);
        if(a==null)return;
        automobileService.setPersona(p,a);

    }

    @Override
    public AutomobileDTO creaAutomobile(CreaAutomobileDTO automobile) {
        Automobile a=automobileMapper.toEntity(automobile);
        a=automobileService.salva(a);
        return automobileMapper.toAutomobileDTO(a);
    }
}
