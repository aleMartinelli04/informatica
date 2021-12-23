package com.martinelli.housework.leva_scommessa;

import java.util.Scanner;

/**
 * Scrivere un programma in Java che simuli il tiro di una leva per giocare una puntata per una scommessa.
 * L'utente giocherà una sua puntata e verranno generati casualmente 3 numeri.
 * Se due numeri estratti sono uguali allora si vince il valore della puntata ma duplicato,
 * altrimenti se sono tutti e 3 uguali si triplica la puntata.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Leva leva = new Leva();

        while (true) {
            System.out.println("Inserisci puntata o * per uscire: ");

            String choice = scanner.nextLine();

            if (choice.equals("*")) {
                break;
            }

            try {
                double puntata = Double.parseDouble(choice);

                String result = leva.punta(puntata);

                System.out.println(result);

            } catch (NumberFormatException e) {
                System.out.println("Inserisci un numero");

            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
        }
    }
}
