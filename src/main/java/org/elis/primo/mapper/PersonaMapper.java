package org.elis.primo.mapper;

import org.elis.primo.dto.request.ModificaPersonaRequestDTO;
import org.elis.primo.dto.request.RegistrazioneRequestDTO;
import org.elis.primo.model.Persona;
import org.springframework.stereotype.Component;

@Component
public class PersonaMapper {

    public Persona toEntity(RegistrazioneRequestDTO requestDTO){
        Persona persona = new Persona();
        persona.setEmail(requestDTO.email());
        persona.setNome(requestDTO.nome());
        persona.setCognome(requestDTO.cognome());
        return persona;
    }

    public Persona toEntity(Persona p, ModificaPersonaRequestDTO requestDTO){
        p.setEmail(requestDTO.email());
        p.setNome(requestDTO.nome());
        p.setCognome(requestDTO.cognome());
        return p;
    }
}
