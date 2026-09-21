package org.elis.primo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Automobile {
    private Long id;
    private String marca;
    private String modello;
    private String targa;
    private String dataImmatricolazione;
    private String cilindrata;
    private Persona proprietario;
    private String colore;
    private int nIncidenti;
    private int km;
    private TipoCambio cambio;
}
