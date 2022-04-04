package gui.magazzino2.classes;

import java.util.ArrayList;
import java.util.List;

public class GestoreArticoli {
    private List<Articolo> articoli;

    public GestoreArticoli() {
        this.articoli = new ArrayList<>();
    }

    public void add(Articolo articolo) {
        articoli.add(articolo);
    }

    public List<Articolo> getArticoli() {
        return articoli;
    }

    public void reset() {
        articoli = new ArrayList<>();
    }
}
