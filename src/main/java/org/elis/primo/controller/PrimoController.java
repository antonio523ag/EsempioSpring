package org.elis.primo.controller;

import org.elis.primo.model.Persona;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/primo")
public class PrimoController {

    //@RequestMapping(method = RequestMethod.GET,value = "/saluta")
    @GetMapping("/saluta")
    public String saluta(){
        return "Davide torna a foggia!";
    }

    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public String saluta2(){
        return "Davide resta a roma";
    }

    @GetMapping("/saluta/{pippo}")
    public String salutaConNome(@PathVariable("pippo") String nome){
        return "ciao a "+nome;
    }

    @PostMapping("/saluta")
    public String salutaConCognome(@RequestParam("pluto") String cognome){
        return "ciao a "+cognome;
    }

    @PostMapping("/descrivi")
    public String descriviPersona(@RequestBody Persona p){
        return p.getNome()+" "+p.getCognome()+" "+p.getEmail();
    }

    @PostMapping("/crea")
    public Persona creaPersona(@RequestParam String nome,
                               @RequestParam String cognome,
                               @RequestParam String email){
        Persona p = new Persona();
        p.setNome(nome);
        p.setCognome(cognome);
        p.setEmail(email);
        return p;
    }
}
