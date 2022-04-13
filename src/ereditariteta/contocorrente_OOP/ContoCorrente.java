package ereditariteta.contocorrente_OOP;

public class ContoCorrente {
    private final String id;

    private double saldo;
    private final String nomeIntestatario;
    private final String cognomeIntestatario;

    private static int contiCreati = 0;

    public ContoCorrente(String nomeIntestatario, String cognomeIntestatario, double saldo) throws Exception {
        contiCreati++;

        if (nomeIntestatario.length() < 3 || cognomeIntestatario.length() < 3) {
            throw new IllegalArgumentException("Il nome e cognome devono essere di almeno 3 caratteri");
        }

        this.nomeIntestatario = nomeIntestatario;
        this.cognomeIntestatario = cognomeIntestatario;

        setSaldo(saldo);

        this.id = creaId("CC");
    }

    public String getId() {
        return id;
    }

    protected String creaId(String tipoConto) {
        return tipoConto.toUpperCase() + nomeIntestatario.substring(0, 3).toUpperCase() + cognomeIntestatario.substring(0, 3).toUpperCase() + String.format("%03d", contiCreati);
    }

    public void versa(double importo) throws Exception {
        setSaldo(saldo + importo);
    }

    public void preleva(double importo) throws Exception {
        setSaldo(saldo - importo);
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) throws Exception {
        if (saldo < 0) {
            throw new Exception("Il saldo non può essere negativo");
        }

        this.saldo = saldo;
    }

    public String getNomeIntestatario() {
        return nomeIntestatario;
    }

    public String getCognomeIntestatario() {
        return cognomeIntestatario;
    }

    @Override
    public String toString() {
        return id;
    }
}
