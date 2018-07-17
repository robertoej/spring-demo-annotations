package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

@Component
public class FileRandomFortuneService implements FortuneService {
    private String[] fortunes;

    private Random myRandom = new Random();

    @PostConstruct
    private void readFortunesFromFile() {
        try {
            byte[] fileBytes = Files.readAllBytes(Paths
                    .get(getClass()
                            .getClassLoader()
                            .getResource("fortunes.db").toURI()));

            String data = new String(fileBytes);

            fortunes = data.split(";");
        } catch (Exception e) {
            fortunes = new String[] { "That's all I could do :-(" };
        }
    }

    @Override
    public String getFortune() {
        int i = myRandom.nextInt(fortunes.length);

        return fortunes[i];
    }
}
