package ereditariteta.gestione_veicoli_OOP;

import java.util.Comparator;

public enum Ordinamenti {
    DATA_ASC("Data crescente", Comparator.comparing(Veicolo::getData)),
    DATA_DESC("Data decrescente", Comparator.comparing(Veicolo::getData).reversed()),
    PREZZO_ASC("Prezzo crescente", Comparator.comparing(Veicolo::getPrezzo)),
    PREZZO_DESC("Prezzo decrescente", Comparator.comparing(Veicolo::getPrezzo).reversed()),
    DESCRIZIONE_ASC("Descrizione crescente", Comparator.comparing(Veicolo::getDescrizione)),
    DESCRIZIONE_DESC("Descrizione decrescente", Comparator.comparing(Veicolo::getDescrizione).reversed());

    private final Comparator<Veicolo> comparator;
    private final String nome;

    Ordinamenti(String nome, Comparator<Veicolo> comparator) {
        this.comparator = comparator;
        this.nome = nome;
    }

    public Comparator<Veicolo> getComparator() {
        return comparator;
    }

    @Override
    public String toString() {
        return nome;
    }
}
