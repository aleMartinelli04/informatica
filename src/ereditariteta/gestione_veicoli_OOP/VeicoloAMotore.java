package ereditariteta.gestione_veicoli_OOP;

import java.util.concurrent.ThreadLocalRandom;

public class VeicoloAMotore extends Veicolo {
    private final double potenza;
    private final Carburanti carburante;

    public VeicoloAMotore(String descrizione, double prezzo, double potenza, Carburanti carburante) {
        super(descrizione, prezzo);
        this.potenza = potenza;
        this.carburante = carburante;
    }

    public static VeicoloAMotore getRandom() {
        return new VeicoloAMotore(
                "Veicolo a motore " + ThreadLocalRandom.current().nextInt(0, 100),
                ThreadLocalRandom.current().nextInt(200_000, 500_000) / 100.0,
                ThreadLocalRandom.current().nextInt(100, 200),
                Carburanti.values()[ThreadLocalRandom.current().nextInt(Carburanti.values().length)]
        );
    }

    public double getPotenza() {
        return potenza;
    }

    public Carburanti getCarburante() {
        return carburante;
    }

    @Override
    public double getPrezzoVendita() {
        return getPrezzo() * (100 - carburante.getSconto()) / 100;
    }
}
