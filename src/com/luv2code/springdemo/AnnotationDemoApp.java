package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        // read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // get the bean from the spring container
        TennisCoach theCoach = context.getBean("tennisCoach", TennisCoach.class);

        // call a method on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        System.out.println("Email: " + theCoach.getEmail());
        System.out.println("Team: " + theCoach.getTeam());

        // close the context
        context.close();
    }
}
