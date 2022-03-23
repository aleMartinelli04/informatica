package gui.magazzino;

public enum Categorie {
    ALIMENTARE("alimentare"),
    UTENSILE("utensile"),
    TECNOLOGICO("teconologico"),
    ALTRO("altro");

    private final String categoria;

    Categorie(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return categoria;
    }
}
