package primo_quadrimestre.housework.persona_lista.exceptions;

public class CognomeInvalidoException extends DatoInvalidoException {
    public CognomeInvalidoException(String cognome) {
        super("Cognome invalido: \"" + cognome + "\"");
    }
}
