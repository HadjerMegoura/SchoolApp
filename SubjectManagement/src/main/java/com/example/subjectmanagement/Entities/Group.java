package com.example.subjectmanagement.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity @AllArgsConstructor @NoArgsConstructor @Data @Table(name = "groupTable")
public class Group {
    @Id
    private  Long id;

    @OneToOne
    private Sujet sujetAffecté;

    @ManyToMany
    @JoinTable(name = "ChoixSujet",joinColumns = @JoinColumn(name = "idGroup"),inverseJoinColumns = @JoinColumn(name = "idSujet"))
    private List<Sujet> sujets;

    @Enumerated(EnumType.STRING)
    private Specialite specialite;

    @OneToOne
    private Compte compte;
}
