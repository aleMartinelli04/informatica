package ereditariteta.contocorrente_OOP;

public class ContoSpeciale extends ContoCorrente {
    private static final double LIMITE = 200;

    public ContoSpeciale(String nomeIntestatario, String cognomeIntestatario, double saldo) throws Exception {
        super(nomeIntestatario, cognomeIntestatario, saldo);
    }

    @Override
    public void preleva(double importo) throws Exception {
        if (importo >= LIMITE) {
            throw new IllegalArgumentException("Prelevo superiore al limite");
        }

        if (importo > getSaldo()) {
            throw new IllegalArgumentException("Prelevo superiore al saldo");
        }

        super.preleva(importo);
    }

    @Override
    protected String creaId(String tipoConto) {
        return super.creaId("CS");
    }
}
