package org.elis.primo.exception;

import lombok.Getter;

@Getter
public class PersonaGiaPresenteException
        extends RuntimeException {
    private String email;

    public PersonaGiaPresenteException(String email) {
        this.email = email;
    }
}
