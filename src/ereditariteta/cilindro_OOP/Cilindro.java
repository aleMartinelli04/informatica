package ereditariteta.cilindro_OOP;

public class Cilindro extends Cerchio {
    private double altezza;

    public Cilindro(double raggio, double altezza) throws Exception {
        super(raggio);
        setAltezza(altezza);
    }

    public void setAltezza(double altezza) throws Exception {
        if (altezza <= 0) {
            throw new Exception("L'altezza deve essere > 0");
        }

        this.altezza = altezza;
    }

    public double volume() {
        return super.area() * altezza;
    }

    @Override
    public String toString() {
        return "Cilindro" +
                "\naltezza=" + altezza +
                "\nraggio=" + getRaggio();
    }
}
