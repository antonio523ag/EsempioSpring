package org.elis.primo.dto.response;

import org.elis.primo.model.TipoCambio;

import java.time.LocalDate;

public record AutomobileDTO(
        Long id,
        String marca,
        String modello,
        String targa,
        LocalDate dataImmatricolazione,
        String cilindrata,
        String nomeProprietario,
        String cognomeProprietario,
        String colore,
        int nIncidenti,
        int km,
        TipoCambio cambio
) {
}
