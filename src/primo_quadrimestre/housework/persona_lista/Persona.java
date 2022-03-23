package primo_quadrimestre.housework.persona_lista;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Persona extends PersonaValidator {
    private String nome;
    private String cognome;
    private int eta;
    private char sesso;

    public Persona(String nome, String cognome, int eta, char sesso) {
        setNome(nome);
        setCognome(cognome);
        setEta(eta);
        setSesso(sesso);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = format(nome);
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = format(cognome);
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public char getSesso() {
        return sesso;
    }

    public void setSesso(char sesso) {
        this.sesso = Character.toUpperCase(sesso);
    }

    /**
     * Formatta una stringa (nome o cognome) in modo da restituirla
     * senza spazi in eccesso e con solo le iniziali maiuscole
     * <br>
     * Es -> "mArIO     luIgi" sarà formattata come "Mario Luigi"
     * <br><br>
     *
     * @param string la stringa che deve essere formattata
     * @return la stringa formattata
     */
    private String format(String string) {
        // divide la stringa per gli spazi
        return Arrays.stream(string.split(" "))
                // filtra le stringe vuote, ossia quelle che sarebbero gli spazi in eccesso
                .filter(part -> !part.equals(""))
                // converte ogni parte con l'iniziale maiuscola e poi tutta minuscola
                .map(part -> Character.toUpperCase(part.charAt(0)) + part.substring(1).toLowerCase())
                // unisce tutte le parti con uno spazio
                .collect(Collectors.joining(" "));
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", eta=" + eta +
                ", sesso=" + sesso +
                '}';
    }
}
