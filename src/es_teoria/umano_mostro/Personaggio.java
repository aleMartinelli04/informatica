package es_teoria.umano_mostro;

public abstract class Personaggio {
    private int forza;

    public Personaggio(int forzaMax) {
        this.forza = forzaMax;
    }

    protected void diminuisciForza(int forza) {
        this.forza -= forza;
    }

    public int getForza() {
        return forza;
    }
}
