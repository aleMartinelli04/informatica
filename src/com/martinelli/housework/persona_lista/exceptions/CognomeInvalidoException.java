package com.martinelli.housework.persona_lista.exceptions;

public class CognomeInvalidoException extends DatoInvalidoException {
    public CognomeInvalidoException(String cognome) {
        super("Cognome invalido: \"" + cognome + "\"");
    }
}
