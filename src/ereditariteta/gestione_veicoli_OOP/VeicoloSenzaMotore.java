package ereditariteta.gestione_veicoli_OOP;

import java.util.concurrent.ThreadLocalRandom;

public class VeicoloSenzaMotore extends Veicolo {
    private final int ruote;
    private boolean licenza;

    public VeicoloSenzaMotore(String descrizione, double prezzo, int ruote, boolean licenza) {
        super(descrizione, prezzo);
        this.ruote = ruote;
        this.licenza = licenza;
    }

    public static VeicoloSenzaMotore getRandom() {
        return new VeicoloSenzaMotore(
                "Veicolo senza motore " + ThreadLocalRandom.current().nextInt(0, 100),
                ThreadLocalRandom.current().nextInt(200_000, 500_000) / 100.0,
                ThreadLocalRandom.current().nextInt(2, 6),
                ThreadLocalRandom.current().nextBoolean());
    }

    public int getRuote() {
        return ruote;
    }

    public boolean hasLicenza() {
        return licenza;
    }

    public void setLicenza(boolean licenza) {
        this.licenza = licenza;
    }

    @Override
    public double getPrezzoVendita() {
        return (licenza ? getPrezzo() * 0.94 : getPrezzo()) + 4 * ruote;
    }
}
