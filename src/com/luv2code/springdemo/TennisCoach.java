package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {
    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    @Autowired
    @Qualifier("fileRandomFortuneService")
    private FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley.";
    }

    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println(">> TennisCoach: inside startup.");
    }

    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println(">> TennisCoach: inside of cleanup.");
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }
}
