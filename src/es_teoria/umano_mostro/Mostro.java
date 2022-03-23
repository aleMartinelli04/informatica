package es_teoria.umano_mostro;

public interface Mostro {
    int FORZAMAX = 15;
    int COSTOATTACCO = 2;

    void azzanna() throws LunaPienaException;
}
