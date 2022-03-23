package es_teoria.umano_mostro;

public class LunaPienaException extends Exception {
    public LunaPienaException() {
        super("C'è la luna piena! Non puoi usare questa mossa!");
    }

    public LunaPienaException(Object ignored) {
        super("Non c'è la luna piena! Non puoi usare questo attacco!");
    }
}
