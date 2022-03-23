package es_teoria.umano_mostro;

public class Main {
    public static void main(String[] args) {
        Eroe eroe = new Eroe();

        Vampiro vampiro = new Vampiro();

        Licantropo licantropo = new Licantropo();

        eroe.combatti();
        System.out.println("EROE: " + eroe.getForza());

        vampiro.azzanna();
        System.out.println("VAMPIRO: " + vampiro.getForza());

        try {
            licantropo.combatti();
            System.out.println("LICANTROPO: " + licantropo.getForza());
        } catch (LunaPienaException e) {
            System.err.println(e.getMessage());
        }

        try {
            licantropo.azzanna();
            System.out.println("LICANTROPO: " + licantropo.getForza());
        } catch (LunaPienaException e) {
            System.err.println(e.getMessage());
        }
    }
}
