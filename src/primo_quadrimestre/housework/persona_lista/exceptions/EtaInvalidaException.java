package primo_quadrimestre.housework.persona_lista.exceptions;

public class EtaInvalidaException extends DatoInvalidoException {
    public EtaInvalidaException(int eta) {
        super("Età invalida: \"" + eta + "\"");
    }
}
