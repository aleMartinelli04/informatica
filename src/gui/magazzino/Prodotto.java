package gui.magazzino;

public class Prodotto {
    private final String codice;
    private final String nome;
    private final double prezzo;
    private final Categorie categoria;
    private int quantita;

    public Prodotto(String codice, String nome, double prezzo, Categorie categoria, int quantita) {
        this.codice = codice;
        this.nome = nome;
        this.prezzo = prezzo;
        this.categoria = categoria;
        this.quantita = quantita;
    }

    public static String[] getCampi() {
        return new String[]{"Codice", "Nome", "Prezzo", "Categoria", "Quantità"};
    }

    public String getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public Categorie getCategoria() {
        return categoria;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public Object[] toArray() {
        return new Object[]{codice, nome, prezzo, categoria, quantita};
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "codice='" + codice + '\'' +
                ", nome='" + nome + '\'' +
                ", prezzo=" + prezzo +
                ", categoria=" + categoria +
                ", quantita=" + quantita +
                '}';
    }
}
