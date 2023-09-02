package com.example.subjectmanagement;

import com.example.subjectmanagement.Entities.*;
import com.example.subjectmanagement.Repositories.EnseignantRepo;
import com.example.subjectmanagement.Repositories.GroupRepo;
import com.example.subjectmanagement.Repositories.SujetRepo;
import com.example.subjectmanagement.Repositories.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SubjectManagementApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SubjectManagementApplication.class, args);
    }
    @Autowired
    GroupRepo groupRepo;
    @Autowired
    SujetRepo sujetRepo;
    @Autowired
    EnseignantRepo enseignantRepo;
    @Autowired
    userRepo userRepo;
    @Override
    public void run(String... args) throws Exception {


    }
}
