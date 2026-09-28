package org.elis.primo.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import org.elis.primo.model.Persona;
import org.elis.primo.model.TipoCambio;

import java.time.LocalDate;

@Getter
public class CreaAutomobileDTO {
    private String marca;
    private String modello;
    private String targa;
    private LocalDate dataImmatricolazione;
    private String cilindrata;
    private String colore;
    private int nIncidenti;
    private int km;
    private TipoCambio cambio;
}
