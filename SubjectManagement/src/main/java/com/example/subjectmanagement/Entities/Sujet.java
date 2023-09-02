package com.example.subjectmanagement.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @AllArgsConstructor @NoArgsConstructor @Data
public class Sujet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String titre;
    @Column(nullable = false)
    private  String description;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    private Boolean choisi=Boolean.FALSE;
    private Boolean valid=Boolean.FALSE;
    private Boolean isAffected=Boolean.FALSE;
    @OneToOne(mappedBy = "sujetAffecté")
    private Group groupA_affecté;


    @ManyToOne
    @JoinColumn(name = "idEnseignant")
    private Enseignant enseignant;

    @ManyToMany(mappedBy = "sujets")
    private List<Group> groups=new ArrayList<>();
}
