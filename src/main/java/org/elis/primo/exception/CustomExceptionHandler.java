package org.elis.primo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {


    @ExceptionHandler(PersonaGiaPresenteException.class)
    public ResponseEntity<String> personaGiaPresenteException
            (PersonaGiaPresenteException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("esiste già un account per "+e.getEmail());
    }
}
