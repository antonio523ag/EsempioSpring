package org.elis.primo.repository;

import org.elis.primo.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona,Long> {
    Optional<Persona> findByAutomobili_id(long id);
    List<Persona> findAllByIndirizzi_id(long id);
}
