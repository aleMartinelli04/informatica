package gui.olimpiadiInformatica;

public class ValidatorePartecipante {
    public void validaCodiceFiscale(String codiceFiscale) {
        if (codiceFiscale == null || codiceFiscale.length() != 16) {
            throw new IllegalArgumentException("Il codice fiscale deve contenere esattamente 16 caratteri");
        }
    }

    public void validaNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Inserisci il nome");
        }
    }

    public void validaClasse(int classe) {
        if (classe < 1 || classe > 4) {
            throw new IllegalArgumentException("La classe deve essere compresa tra 1 e 4");
        }
    }

    public void validaPunteggio(int punteggio) {
        if (punteggio < -30 || punteggio > 30) {
            throw new IllegalArgumentException("Il punteggio deve essere compreso tra -30 e 30");
        }
    }
}
