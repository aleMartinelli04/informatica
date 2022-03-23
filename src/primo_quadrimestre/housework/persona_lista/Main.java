package primo_quadrimestre.housework.persona_lista;

import primo_quadrimestre.housework.persona_lista.exceptions.CognomeInvalidoException;
import primo_quadrimestre.housework.persona_lista.exceptions.EtaInvalidaException;
import primo_quadrimestre.housework.persona_lista.exceptions.NomeInvalidoException;
import primo_quadrimestre.housework.persona_lista.exceptions.SessoInvalidoException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String menu = """
                1. Inserisci nuova persona
                2. Stampa tutte le persone
                0. Esci""";
        Scanner scanner = new Scanner(System.in);

        List<Persona> persone = new ArrayList<>();
        PersonaValidator validator = new PersonaValidator();

        while (true) {
            System.out.println(menu);

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Inserisci nome:");
                    String nome = scanner.nextLine();

                    try {
                        validator.validateNome(nome);
                    } catch (NomeInvalidoException e) {
                        System.out.println(e.getMessage());
                        break;
                    }

                    System.out.println("Inserisci cognome:");
                    String cognome = scanner.nextLine();

                    try {
                        validator.validateCognome(cognome);
                    } catch (CognomeInvalidoException e) {
                        System.out.println(e.getMessage());
                        break;
                    }

                    System.out.println("Inserisci età:");
                    int eta;
                    try {
                        eta = scanner.nextInt();
                        scanner.nextLine();

                        validator.validateEta(eta);

                    } catch (InputMismatchException e) {
                        System.out.println("Inserisci un numero valido");
                        scanner.nextLine();
                        break;

                    } catch (EtaInvalidaException e) {
                        System.out.println(e.getMessage());
                        break;
                    }

                    System.out.println("Inserisci sesso (M/F):");
                    char sesso;
                    try {
                        sesso = scanner.nextLine().charAt(0);

                        validator.validateSesso(sesso);

                    } catch (SessoInvalidoException e) {
                        System.out.println(e.getMessage());
                        break;
                    }

                    Persona persona = new Persona(nome, cognome, eta, sesso);
                    persone.add(persona);
                    break;

                case "2":
                    if (persone.isEmpty()) {
                        System.out.println("Non ci sono persone nella lista");
                        break;
                    }

                    persone.forEach(System.out::println);
                    break;

                case "0":
                    return;

                default:
                    System.out.println("Inserisci una scelta valida");
            }
        }
    }
}
