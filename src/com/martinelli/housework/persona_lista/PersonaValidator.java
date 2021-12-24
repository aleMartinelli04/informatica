package com.martinelli.housework.persona_lista;

import com.martinelli.housework.persona_lista.exceptions.CognomeInvalidoException;
import com.martinelli.housework.persona_lista.exceptions.EtaInvalidaException;
import com.martinelli.housework.persona_lista.exceptions.NomeInvalidoException;
import com.martinelli.housework.persona_lista.exceptions.SessoInvalidoException;

public class PersonaValidator {
    public void validateNome(String nome) throws NomeInvalidoException {
        if (nome == null || nome.length() <= 3) {
            throw new NomeInvalidoException(nome);
        }
    }

    public void validateCognome(String cognome) throws CognomeInvalidoException {
        if (cognome == null || cognome.length() <= 3) {
            throw new CognomeInvalidoException(cognome);
        }
    }

    public void validateEta(int eta) throws EtaInvalidaException {
        if (eta < 0 || eta > 120) {
            throw new EtaInvalidaException(eta);
        }
    }

    public void validateSesso(char sesso) throws SessoInvalidoException {
        sesso = Character.toUpperCase(sesso);

        if (sesso != 'M' && sesso != 'F') {
            throw new SessoInvalidoException(sesso);
        }
    }
}
