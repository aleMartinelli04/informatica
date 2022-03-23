package gui.magazzino;

public class ValidatoreProdotto {
    public void validaCodice(String codice) throws Exception {
        if (codice == null || codice.length() == 0) {
            throw new Exception("Codice invalido");
        }
    }

    public void validaNome(String nome) throws Exception {
        if (nome == null || nome.length() == 0) {
            throw new Exception("Nome invalido");
        }
    }

    public void validaQuantita(int quantita) throws Exception {
        if (quantita <= 0) {
            throw new Exception("Quantità invalida");
        }
    }

    public void validaPrezzo(double prezzo) throws Exception {
        if (prezzo <= 0) {
            throw new Exception("Prezzo invalido");
        }
    }

    public void validaProdotto(String codice, String nome, double prezzo, int quantita) throws Exception {
        validaCodice(codice);
        validaNome(nome);
        validaQuantita(quantita);
        validaPrezzo(prezzo);
    }

}
