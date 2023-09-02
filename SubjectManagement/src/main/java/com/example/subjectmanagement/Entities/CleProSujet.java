package com.example.subjectmanagement.Entities;

import javax.persistence.Embeddable;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class CleProSujet implements Serializable {
    @ManyToOne
    private Enseignant enseignant;
    @ManyToOne
    private Sujet sujet;
}
