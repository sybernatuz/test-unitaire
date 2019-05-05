package com.esgi.services;

import java.util.Random;

public class DBConnection {

    public boolean save(Exchange exchange) {
        Random random = new Random();
        return random.nextBoolean();
    }
}
