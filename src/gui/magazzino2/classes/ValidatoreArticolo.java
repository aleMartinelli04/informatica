package gui.magazzino2.classes;

public class ValidatoreArticolo {
    public void validaDescrizione(String descrizione) throws Exception {
        if (descrizione == null || descrizione.length() < 3) {
            throw new Exception("Descrizione invalida");
        }
    }

    public void validaQuantita(int quantita) throws Exception {
        if (quantita <= 0) {
            throw new Exception("Quantità invalida");
        }
    }

    public void validaPrezzo(double prezzo) throws Exception{
        if (prezzo <= 0) {
            throw new Exception("Prezzo non valido");
        }
    }

    public void validaArticolo(String descrizione, int quantita, double prezzo) throws Exception {
        validaDescrizione(descrizione);
        validaQuantita(quantita);
        validaPrezzo(prezzo);
    }
}
