package org.elis.primo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Automobile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modello;
    @Column(unique = true,length = 7)
    private String targa;
    @Column(nullable = false)
    private LocalDate dataImmatricolazione;
    private String cilindrata;
    @ManyToOne
    @JoinColumn(name = "id_persona",
            foreignKey = @ForeignKey(name = "FK_PERSONA"))
    private Persona proprietario;
    private String colore;
    private int nIncidenti;
    private int km;
    private TipoCambio cambio;
}
