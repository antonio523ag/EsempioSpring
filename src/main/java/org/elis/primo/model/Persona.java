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
    @OneToMany(mappedBy = "proprietario")
    //il "proprietario" è l'attributo java non SQL
    private List<Automobile> automobili;

}
