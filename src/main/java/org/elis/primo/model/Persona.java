package org.elis.primo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames =
                {"name","surname","mail_address"}
                , name = "persona_univoca")
})
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String nome;
    @Column(name = "surname")
    private String cognome;
    @Column(name = "mail_address")
    private String email;
    //@JsonIgnore
    @OneToMany(mappedBy = "proprietario")
    //il "proprietario" è l'attributo java non SQL
    private List<Automobile> automobili;
    @ManyToMany
    @JoinTable(name = "indirizzi_persone",
            //questo si riferisce all'entità dove sto scrivendo
            joinColumns = @JoinColumn(name = "id_persona"),
            //questo si riferisce all'altra entità, quella dell'attributo in basso
            inverseJoinColumns = @JoinColumn(name = "id_indirizzo"),
            uniqueConstraints = {
            @UniqueConstraint(name = "persona_indirizzo_univoca",
                    columnNames = {"id_persona","id_indirizzo"})
            }

        )
    private List<Indirizzo> indirizzi;

}
