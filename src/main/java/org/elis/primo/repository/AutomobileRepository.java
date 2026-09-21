package org.elis.primo.repository;

import org.elis.primo.model.Automobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AutomobileRepository
        extends JpaRepository<Automobile, Long> {

    List<Automobile> findAllByMarca(String marca);

    @Query(value = "select a from Automobile a where a.modello = :modello")
    List<Automobile> trovaAutoPerModello(String modello);

    @Query(nativeQuery = true, value = "select * from Automobile where targa = :targa")
    Optional<Automobile> trovaByTarga(String targa);
}
