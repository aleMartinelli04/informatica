package ereditariteta.gestione_veicoli_OOP;

public class VeicoloSenzaMotore extends Veicolo {
    private final int ruote;
    private boolean licenza;

    public VeicoloSenzaMotore(String descrizione, double prezzo, int ruote, boolean licenza) {
        super(descrizione, prezzo);
        this.ruote = ruote;
        this.licenza = licenza;
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
    public double calcolaPrezzo() {
        return licenza ? getPrezzo() * 0.94 + 4 * ruote : getPrezzo();
    }

    @Override
    public String toString() {
        return super.toString() + ", ruote: " + ruote + ", licenza: " + (licenza ? "si" : "no");
    }
}
