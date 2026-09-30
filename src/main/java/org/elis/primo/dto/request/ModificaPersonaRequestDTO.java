package org.elis.primo.dto.request;

public record ModificaPersonaRequestDTO(
        long id,
        String nome,
        String cognome,
        String email
) {
}
