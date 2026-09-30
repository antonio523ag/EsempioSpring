package org.elis.primo.dto.request;

import lombok.ToString;

public record ModificaPersonaRequestDTO(
        long id,
        String nome,
        String cognome,
        String email,
        long versione) {
}