package org.elis.primo.facade.def;

import org.elis.primo.dto.request.ModificaPersonaRequestDTO;
import org.elis.primo.dto.request.RegistrazioneRequestDTO;
import org.elis.primo.dto.response.PersonaDTO;

public interface PersonaFacade {

    void registrazione(RegistrazioneRequestDTO request);
    void modifica(ModificaPersonaRequestDTO request);

    PersonaDTO getById(long id);
}
