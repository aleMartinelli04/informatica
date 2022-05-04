package ereditariteta.gestione_veicoli_OOP;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public abstract class Veicolo {
    private final String codice;
    private final Date data;
    private String descrizione;
    private double prezzo;

    public Veicolo(String descrizione, double prezzo) {
        this.codice = UUID.randomUUID().toString();
        this.data = new Date();
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }

    public String getCodice() {
        return codice;
    }

    public Date getData() {
        return data;
    }

    public String getFormattedDate() {
        return DateFormat.getDateInstance(DateFormat.SHORT, Locale.ENGLISH).format(data);
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public final double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public abstract double getPrezzoVendita();

    @Override
    public final String toString() {
        return descrizione;
    }
}
