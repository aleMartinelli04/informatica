package com.martinelli.university;

public class Main {
    public static void main(String[] args) {
        University university = new University();

        for (int i = 0; i < 100; i++) {
            university.add(
                    new Professor("nome"+ i,
                            "cognome" + i,
                            i % 10
                    )
            );
        }


        System.out.println(university.etaMinima());

        university.trovaGiovani().forEach(System.out::println);
    }
}
