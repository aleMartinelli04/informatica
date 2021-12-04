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
    }

    public List<Professor> trovaGiovani() {
        if (professors.isEmpty()) {
            throw new IllegalStateException("List of Professor is empty");
        }

        return professors.stream()
                .filter(dipendente -> dipendente.getAge() == etaMinima())
                .collect(Collectors.toList());
    }
}
