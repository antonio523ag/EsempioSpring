package org.elis.primo.service.jpaimpl;

import lombok.RequiredArgsConstructor;
import org.elis.primo.model.Automobile;
import org.elis.primo.model.Persona;
import org.elis.primo.repository.PersonaRepository;
import org.elis.primo.service.def.AutomobileService;
import org.elis.primo.service.def.PersonaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository repo;
    private final AutomobileService automobileService;

    @Override
    public Persona creaPersona(Persona persona) {
        return null;
    }

    @Override
    public Persona getById(long id) {
        return null;
    }

    @Override
    public Persona getPersonaByIdAutomobile(long id) {
        return repo.findByAutomobili_id(id).orElse(null);
    }

    @Override
    public List<Persona> getPersone() {
        return List.of();
    }

    @Override
    public List<Persona> getPersoneByIdIndirizzo(long id) {
        return repo.findAllByIndirizzi_id(id);
    }

    @Override
    public Persona gerPersonaByTarga(String targa) {
        Automobile a=automobileService.getAutomobile(targa);
        return getPersonaByIdAutomobile(a.getId());
    }
}
