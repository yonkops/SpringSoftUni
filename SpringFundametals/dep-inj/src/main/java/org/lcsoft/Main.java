package org.lcsoft;

import org.lcsoft.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("org.lcsoft");

        UserService userService = context.getBean(UserService.class);

        System.out.println(userService.findYoungestUser().orElseThrow());
    }
}