package es_teoria.umano_mostro;

public class Eroe extends Personaggio implements Umano{
    public Eroe() {
        super(FORZAMAX);
    }

    @Override
    public void combatti() {
        diminuisciForza(COSTOATTACCO);
    }
}
