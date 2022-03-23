package primo_quadrimestre.housework.sasso_carta_forbice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Inserisci scelta o * per uscire:");
            String choice = scanner.nextLine();

            if (choice.equals("*")) {
                return;
            }

            SassoCartaForbice u1, u2;

            try {
                u1 = SassoCartaForbice.valueOf(choice.toUpperCase());
            } catch (Exception e) {
                System.out.println("Scelta non valida");
                continue;
            }

            System.out.println("Inserisci seconda scelta:");
            String choice2 = scanner.nextLine();

            try {
                u2 = SassoCartaForbice.valueOf(choice2.toUpperCase());
            } catch (Exception e) {
                System.out.println("Scelta non valida");
                continue;
            }

            if (u1.vinceContro(u2)) {
                System.out.println("Vince " + u1.getNome());
            } else if (u1.perdeContro(u2)) {
                System.out.println("Vince " + u2.getNome());
            } else {
                System.out.println("Pareggio!");
            }
        }
    }
}
