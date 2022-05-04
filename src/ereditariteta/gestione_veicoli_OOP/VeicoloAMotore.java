package ereditariteta.gestione_veicoli_OOP;

public class VeicoloAMotore extends Veicolo {
    private final double potenza;
    private final Carburanti carburante;

    public VeicoloAMotore(String descrizione, double prezzo, double potenza, Carburanti carburante) {
        super(descrizione, prezzo);
        this.potenza = potenza;
        this.carburante = carburante;
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
