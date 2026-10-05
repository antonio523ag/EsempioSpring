package org.elis.primo.service.jpaimpl;

import lombok.RequiredArgsConstructor;
import org.elis.primo.exception.PersonaGiaPresenteException;
import org.elis.primo.model.Automobile;
import org.elis.primo.model.Persona;
import org.elis.primo.repository.PersonaRepository;
import org.elis.primo.service.def.AutomobileService;
import org.elis.primo.service.def.PersonaService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository repo;
    private final AutomobileService automobileService;


    @Override
    public Persona salva(Persona persona) {
        try {
            return repo.save(persona);
        }catch (Exception e){
            if(e instanceof DataIntegrityViolationException ex){
                //throw new PersonaGiaPresenteException(persona.getEmail());
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT,persona.getNome()+" "+
                        persona.getCognome()+
                        " è già presente con questa mail");
            }else return null;
        }

    }

    @Override
    public Persona getById(long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Persona getPersonaByIdAutomobile(long id) {
        return repo.findByAutomobili_id(id).orElse(null);
    }

    @Override
    public List<Persona> getPersone() {
        return repo.findAll();
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
