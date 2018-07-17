package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {
    private String[] fortunes = new String[] {
            "That's just random [1]!",
            "That's just random [2]!",
            "That's just random [3]!"
    };

    private Random myRandom = new Random();

    @Override
    public String getFortune() {
        int i = myRandom.nextInt(fortunes.length);

        return fortunes[i];
    }
}
