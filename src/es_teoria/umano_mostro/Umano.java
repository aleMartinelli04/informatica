package es_teoria.umano_mostro;

public interface Umano {
    int FORZAMAX = 10;
    int COSTOATTACCO = 3;

    void combatti() throws LunaPienaException;
}
