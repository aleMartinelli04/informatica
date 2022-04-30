package ereditariteta.gestione_veicoli_OOP;

public enum Carburanti {
    BENZINA(0),
    DIESEL(0),
    GPL(2),
    METANO(6),
    ELETTRICO(9);

    private final int sconto;

    Carburanti(int sconto) {
        this.sconto = sconto;
    }

    public int getSconto() {
        return sconto;
    }

    @Override
    public String toString() {
        return this.name().substring(0, 1).toUpperCase() + this.name().substring(1).toLowerCase();
    }
}
