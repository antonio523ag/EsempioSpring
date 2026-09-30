package org.elis.primo.facade.def;

import org.elis.primo.dto.request.ModificaPersonaRequestDTO;
import org.elis.primo.dto.request.RegistrazioneRequestDTO;

public interface PersonaFacade {

    void registrazione(RegistrazioneRequestDTO request);
    void modifica(ModificaPersonaRequestDTO request);
}
