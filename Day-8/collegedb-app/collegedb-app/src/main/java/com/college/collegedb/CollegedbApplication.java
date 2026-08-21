package com.college.collegedb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CollegedbApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollegedbApplication.class, args);
        System.out.println("Project -> http://localhost:8080/api/contacts");
        System.out.println("H2 Database -> http://localhost:8080/h2-console");
    }

}
