package com.example.leetcodereminder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LeetCodeReminderApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeetCodeReminderApplication.class, args);
    }

}
