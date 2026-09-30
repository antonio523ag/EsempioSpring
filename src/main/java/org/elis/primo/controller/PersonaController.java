package org.elis.primo.controller;

import lombok.RequiredArgsConstructor;
import org.elis.primo.dto.request.ModificaPersonaRequestDTO;
import org.elis.primo.dto.request.RegistrazioneRequestDTO;
import org.elis.primo.dto.response.PersonaDTO;
import org.elis.primo.facade.def.PersonaFacade;
import org.elis.primo.model.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
@RequiredArgsConstructor
public class PersonaController {

    private final PersonaFacade facade;

    @PostMapping("/add")
    public ResponseEntity<Void> registrati(@RequestBody RegistrazioneRequestDTO request){
        facade.registrazione(request);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/update")
    public ResponseEntity<Void> modifica(@RequestBody ModificaPersonaRequestDTO requestDTO){
        facade.modifica(requestDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<PersonaDTO> getById(@PathVariable long id){
        PersonaDTO p=facade.getById(id);
        return ResponseEntity.ok(p);
    }


}
