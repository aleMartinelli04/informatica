package ereditariteta.cilindro_OOP;

public class Cerchio {
    private double raggio;

    public Cerchio(double raggio) throws Exception {
        setRaggio(raggio);
    }

    public double getRaggio() {
        return raggio;
    }

    public void setRaggio(double raggio) throws Exception {
        if (raggio <= 0) {
            throw new Exception("Il raggio deve essere > 0");
        }

        this.raggio = raggio;
    }

    public double area() {
        return Math.PI * Math.pow(raggio, 2);
    }

    @Override
    public String toString() {
        return "Cerchio" +
                "\nraggio=" + raggio;
    }
}
