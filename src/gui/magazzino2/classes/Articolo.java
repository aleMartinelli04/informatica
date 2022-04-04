package gui.magazzino2.classes;

public class Articolo {
    private final String descrizione;
    private int quantita;
    private final double prezzo;

    public Articolo(String descrizione, int quantita, double prezzo) {
        this.descrizione = descrizione;
        this.quantita = quantita;
        this.prezzo = prezzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public double getPrezzo() {
        return prezzo;
    }

    @Override
    public String toString() {
        return "Articolo{" +
                "descrizione='" + descrizione + '\'' +
                ", quantita=" + quantita +
                ", prezzo=" + prezzo +
                '}';
    }
}
