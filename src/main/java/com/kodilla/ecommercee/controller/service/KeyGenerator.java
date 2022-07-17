package com.kodilla.ecommercee.controller.service;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class KeyGenerator {
    Timer timer = new Timer();
    String generatedKey;

    private String generateRandomKey() {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
                +"lmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        String result = "";
        for (int i = 0; i < 13; i++)
            result += chars.charAt(rnd.nextInt(chars.length()));
        return result;
    }

    public String activateKeyForTime() {

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                generatedKey = generateRandomKey();
            }
        };

        timer.scheduleAtFixedRate(timerTask,0,500000);
        return generatedKey;
    }
}
