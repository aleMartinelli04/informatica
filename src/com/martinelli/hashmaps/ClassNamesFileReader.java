package com.martinelli.hashmaps;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassNamesFileReader {
    public static List<Classes> getClassNames() {
        Scanner scanner;

        try {
            scanner = new Scanner(new FileReader("classNames.txt"));
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }

        List<Classes> toReturn = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();

            String name = string.substring(1);
            int grade = Integer.parseInt(String.valueOf(string.charAt(0)));

            toReturn.add(new Classes(grade, name));
        }

        return toReturn;
    }
}
