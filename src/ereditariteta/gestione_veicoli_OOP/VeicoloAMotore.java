package ereditariteta.gestione_veicoli_OOP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public double calcolaPrezzo() {
        return getPrezzo() * (100 - carburante.getSconto()) / 100;
    }

    @Override
    public Object[] getAsArray() {
        List<Object> list = new ArrayList<>(Arrays.asList(super.getAsArray()));

        list.add(potenza);
        list.add(carburante);

        return list.toArray();
    }
}
