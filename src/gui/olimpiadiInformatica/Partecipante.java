package gui.olimpiadiInformatica;

public class Partecipante {
    private final String codiceFiscale;
    private String nome;
    private int classe;
    private int punteggio;

    public final static String SPLIT = "_";

    public Partecipante(String codiceFiscale, String nome, int classe, int punteggio) {
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.classe = classe;
        this.punteggio = punteggio;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getClasse() {
        return classe;
    }

    public void setClasse(int classe) {
        this.classe = classe;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    @Override
    public String toString() {
        return "Partecipante{" +
                "codiceFiscale='" + codiceFiscale + '\'' +
                ", nome='" + nome + '\'' +
                ", classe=" + classe +
                ", punteggio=" + punteggio +
                '}';
    }

    public String serialzie() {
        return codiceFiscale + SPLIT + nome + SPLIT + classe + SPLIT + punteggio;
    }

    public static Partecipante deserialzie(String partecipantString) {
        String[] parts = partecipantString.split(SPLIT);

        return new Partecipante(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
    }
}
