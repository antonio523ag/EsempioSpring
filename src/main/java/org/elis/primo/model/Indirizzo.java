package org.elis.primo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"via","civico","cap"},
        name = "indirizzo_univoco")
})
public class Indirizzo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String via;
    private String civico;
    private String cap;
    private String citta;
}
