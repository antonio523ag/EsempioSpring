package org.elis.primo.service.def;

import org.elis.primo.model.Persona;

import java.util.List;

public interface PersonaService {
    Persona creaPersona(Persona persona);
    Persona getById(long id);
    Persona getPersonaByIdAutomobile(long id);
    List<Persona> getPersone();
    List<Persona> getPersoneByIdIndirizzo(long id);
    Persona gerPersonaByTarga(String targa);

}
