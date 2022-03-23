package primo_quadrimestre.cd_music;

import primo_quadrimestre.cd_music.exceptions.InvalidArgumentException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Archivio archivio = new Archivio();
        CdVerificator cdVerificator = new CdVerificator();

        while (true) {
            System.out.print("""
                    \t1. Inserisci nuovo Cd
                    \t2. Stampa tutti i Cd
                    \t3. Stampa i Cd in vetrina
                    \t4. Stampa i Cd non in vetrina
                    \t5. Importa libri dal file
                    \t6. Salva libri sul file
                    \t0. Esci
                    >""");

            switch (scanner.nextLine()) {
                case "1" -> {
                    System.out.print("Inserisci nome:\n>");

                    String titolo = scanner.nextLine();
                    try {
                        cdVerificator.checkTitle(titolo);
                    } catch (InvalidArgumentException e) {
                        System.out.println(e.getMessage());
                        break;
                    }

                    System.out.print("Inserisci interprete:\n>");

                    String interprete = scanner.nextLine();
                    try {
                        cdVerificator.checkInterprete(interprete);
                    } catch (InvalidArgumentException e) {
                        System.out.println(e.getMessage());
                        break;
                    }

                    System.out.println("Inserisci prezzo:");

                    double prezzo = scanner.nextDouble();
                    scanner.nextLine();
                    try {
                        cdVerificator.checkPrezzo(prezzo);
                    } catch (InvalidArgumentException e) {
                        System.out.println(e.getMessage());
                        break;
                    }

                    try {
                        Cd cd = new Cd(titolo, interprete, prezzo);
                        archivio.add(cd);

                        System.out.println("Libro " + cd.getTitolo() + " aggiunto con successo!");

                    } catch (InvalidArgumentException ignored) {
                    }
                }

                case "2" -> archivio.getCds().forEach(System.out::println);

                case "3" -> {
                    archivio.getCdInVetrina().forEach(System.out::println);
                    System.out.println("Libri in vetrina: " + archivio.getCdInVetrina().size());
                }

                case "4" -> archivio.getCdNonInVetrina().forEach(System.out::println);

                case "5" -> {
                    try {
                        archivio.add(new CdFileReader().readCds());

                    } catch (IOException e) {
                        System.out.println("File non trovato");
                    }
                }

                case "6" -> {
                    try {
                        new CDFileWriter().writeCdsOnFile((Cd) archivio.getCds());
                    } catch (IOException e) {
                        System.out.println("File non trovato");
                    }
                }

                case "0" -> {
                    return;
                }

                default -> System.out.println("Inserisci scelta valida!");
            }
        }
    }
}
