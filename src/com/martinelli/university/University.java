package com.martinelli.university;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class University {
    private final List<Professor> professors;

    public University() {
        this.professors = new ArrayList<>();
    }

    public void add(Professor dipendente) {
        professors.add(dipendente);
    }

    public int etaMinima() {
        if (professors.isEmpty()) {
            throw new IllegalStateException("List of Professor is empty");
        }

        return professors.stream()
                .map(Professor::getAge)
                .findFirst()
                .get();

        /**
         * int minAge = professors.get(0).getAge();
         * for (int i = 0; i < professors.size(); i++) {
         *     minAge = Math.min(minAge, professors.get(i).getAge());
         * }
         *
         * return minAge;
         */
    }

    public List<Professor> trovaGiovani() {
        if (professors.isEmpty()) {
            throw new IllegalStateException("List of Professor is empty");
        }

        return professors.stream()
                .filter(dipendente -> dipendente.getAge() == etaMinima())
                .collect(Collectors.toList());

        /**
         * List<Professors> toReturn = new ArrayList<>();
         * for (Professor professor : professors) {
         *      if (professor.getAge() < etaMinima()) {
         *          toReturn.add(professor);
         *      }
         *  }
         *  return toReturn;
         */
    }
}
