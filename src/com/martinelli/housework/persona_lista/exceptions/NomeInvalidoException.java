package com.martinelli.housework.persona_lista.exceptions;

public class NomeInvalidoException extends DatoInvalidoException {
    public NomeInvalidoException(String nome) {
        super("Nome invalido: \"" + nome + "\"");
    }
}
