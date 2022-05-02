package ereditariteta.gestione_veicoli_OOP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public double getPrezzoVendita() {
        return licenza ? getPrezzo() * 0.94 + 4 * ruote : getPrezzo();
    }

    @Override
    public Object[] getAsArray() {
        List<Object> list = new ArrayList<>(Arrays.asList(super.getAsArray()));

        list.add(ruote);
        list.add(licenza);

        return list.toArray();
    }
}
