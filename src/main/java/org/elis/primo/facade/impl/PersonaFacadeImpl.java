package org.elis.primo.facade.impl;

import lombok.RequiredArgsConstructor;
import org.elis.primo.dto.request.ModificaPersonaRequestDTO;
import org.elis.primo.dto.request.RegistrazioneRequestDTO;
import org.elis.primo.facade.def.PersonaFacade;
import org.elis.primo.mapper.PersonaMapper;
import org.elis.primo.model.Persona;
import org.elis.primo.service.def.PersonaService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonaFacadeImpl implements PersonaFacade {

    private final PersonaService personaService;
    private final PersonaMapper personaMapper;

    @Override
    public void registrazione(RegistrazioneRequestDTO request) {
        Persona p=personaMapper.toEntity(request);
        personaService.salva(p);
    }

    @Override
    public void modifica(ModificaPersonaRequestDTO request) {
        Persona p=personaService.getById(request.id());
        personaMapper.toEntity(p,request);
        personaService.salva(p);
    }
}
