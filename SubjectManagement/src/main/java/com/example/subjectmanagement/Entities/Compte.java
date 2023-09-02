package com.example.subjectmanagement.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private   String lastName;
    private   String email;
    @Enumerated
    private Type type;
    private   String password;
}
