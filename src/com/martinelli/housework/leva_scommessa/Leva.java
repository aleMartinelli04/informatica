package com.martinelli.housework.leva_scommessa;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Leva {
    Random random;

    public Leva() {
        this.random = new Random();
    }

    public String punta(double puntata) throws Exception {
        if (puntata <= 0) {
            throw new Exception("La puntata non può essere <= 0");
        }

        int[] numeri = getNumeri();

        if (numeri[0] == numeri[1] && numeri[1] == numeri[2]) {
            return "Triplo " + numeri[0] + " " + Arrays.toString(numeri) + ": puntata guadagnata -> " +
                    NumberFormat.getCurrencyInstance().format(puntata * 3);
        }

        if (numeri[0] == numeri[1] || numeri[0] == numeri[2] || numeri[1] == numeri[2]) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int numero : numeri) {
                map.put(numero, map.getOrDefault(numero, 0) + 1);
            }

            int doppio = map.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .toList()
                    .get(map.size() - 1)
                    .getKey();


            return "Doppio " + doppio + " " + Arrays.toString(numeri) + ": puntata guadagnata -> " +
                    NumberFormat.getCurrencyInstance().format(puntata * 2);
        }

        throw new Exception("La puntata è andata male, i numeri usciti sono " + Arrays.toString(numeri));
    }

    private int[] getNumeri() {
        return new int[]{
                random.nextInt(10) + 1,
                random.nextInt(10) + 1,
                random.nextInt(10) + 1
        };
    }
}
