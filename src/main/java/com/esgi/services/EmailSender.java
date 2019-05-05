package com.esgi.services;

import com.esgi.dto.User;

import java.util.Random;

public class EmailSender {

    public boolean sendEmail(User receiver, String content) {
        Random random = new Random();
        return random.nextBoolean();
    }
}
