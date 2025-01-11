package com.ernesto.banco_multiplo.service;

import java.util.Random;

public class PasswordUtil {


    public String generatePassword() {
        Random random = new Random();
        int number = random.nextInt(4);

        return String.format("%04d", number);
    }
}
