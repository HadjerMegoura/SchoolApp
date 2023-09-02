package com.example.subjectmanagement.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Enseignant {
    @Id
    private Long id;

    @OneToMany(mappedBy = "enseignant")
    private Collection<Sujet> sujets;
    @OneToOne
    private Compte compte;
}
