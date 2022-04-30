package ereditariteta.gestione_veicoli_OOP;

import java.util.UUID;

public abstract class Veicolo {
    private final String codice;
    private String descrizione;
    private double prezzo;

    public Veicolo(String descrizione, double prezzo) {
        this.codice = UUID.randomUUID().toString();
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }

    public String getCodice() {
        return codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public abstract double calcolaPrezzo();

    @Override
    public String toString() {
        return "Veicolo{" + "codice='" + codice + '\'' + ", descrizione='" + descrizione + '\'' + ", prezzo=" + prezzo + '}';
    }
}