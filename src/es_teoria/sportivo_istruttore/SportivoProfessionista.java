package es_teoria.sportivo_istruttore;

public class SportivoProfessionista extends Sportivo {
    private Livello livello;

    public SportivoProfessionista(String nome, String cognome, String codiceFiscale, int eta, Sport sport, Livello livello) {
        super(nome, cognome, codiceFiscale, eta, sport);
        this.livello = livello;
    }

    public Livello getLivello() {
        return livello;
    }

    public void setLivello(Livello livello) {
        this.livello = livello;
    }

    @Override
    public String toString() {
        return "SportivoProfessionista{" + super.toString() +
                "livello=" + livello +
                '}';
    }
}
