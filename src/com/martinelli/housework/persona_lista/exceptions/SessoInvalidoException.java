package com.martinelli.housework.persona_lista.exceptions;

public class SessoInvalidoException extends DatoInvalidoException {
    public SessoInvalidoException(char sesso) {
        super("Sesso invalido: \"" + sesso + "\"");
    }
}
