package gui.magazzino;

public class Serializzatore {
    public final static String SPLIT = "";

    public String serializza(Prodotto prodotto) {
        return prodotto.getCodice() + SPLIT + prodotto.getNome() + SPLIT + prodotto.getPrezzo() + SPLIT + prodotto.getCategoria() + SPLIT + prodotto.getQuantita();
    }

    public Prodotto deserializza(String prodotto) {
        String[] parti = prodotto.split(SPLIT);

        return new Prodotto(parti[0], parti[1], Double.parseDouble(parti[2]), Categorie.valueOf(parti[3].toUpperCase()), Integer.parseInt(parti[4]));
    }
}
