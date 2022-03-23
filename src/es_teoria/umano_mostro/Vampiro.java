package es_teoria.umano_mostro;

public class Vampiro extends Personaggio implements Mostro{
    public Vampiro() {
        super(FORZAMAX);
    }

    @Override
    public void azzanna() {
        diminuisciForza(COSTOATTACCO);
    }
}
