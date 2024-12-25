package com.ernesto.banco_multiplo.util;

import java.util.Random;


public class GeradorConta {

    public static String gerar() {
        Random random = new Random();
        long number = random.nextLong(999999999);
        long number1 = random.nextLong(999);
        System.out.println(number + " " + number1);
        return String.format("%09d", number) + String.format( "%03d", number1);
    }
}
