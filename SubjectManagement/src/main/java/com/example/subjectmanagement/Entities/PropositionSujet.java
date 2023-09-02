package com.example.subjectmanagement.Entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class PropositionSujet {
    @EmbeddedId
    private CleProSujet cleProSujet;

}
