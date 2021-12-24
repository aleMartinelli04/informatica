package com.martinelli.housework.persona_lista.exceptions;

public class EtaInvalidaException extends DatoInvalidoException {
    public EtaInvalidaException(int eta) {
        super("Età invalida: \"" + eta + "\"");
    }
}
