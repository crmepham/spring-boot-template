package com.github.crmepham;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Main access to the frontend application.
 */
@EntityScan("com.github.crmepham")
@SpringBootApplication
public class Frontend {
    public static void main(String[] args) {
        SpringApplication.run(Frontend.class, args);
    }
}
