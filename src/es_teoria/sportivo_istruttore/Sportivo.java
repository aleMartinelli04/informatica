package es_teoria.sportivo_istruttore;

public class Sportivo extends Persona implements Partecipante {
    private Sport sport;

    public Sportivo(String nome, String cognome, String codiceFiscale, int eta, Sport sport) {
        super(nome, cognome, codiceFiscale, eta);
        this.sport = sport;
    }

    @Override
    public String gareggia() {
        return getNome() + " gareggia nello sport " + sport;
    }

    @Override
    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    @Override
    public String toString() {
        return super.toString() + "Sportivo{" + super.toString() + "sport=" + sport + '}';
    }
}
