package com.example.subjectmanagement.Services;

import com.example.subjectmanagement.Entities.Enseignant;

import java.util.List;

public interface EnseignantService {
    List<Enseignant> getAllEns();
    Enseignant DetailEnseignant(Long id);
    Enseignant UpdateEns(Enseignant ens,Long id);
    void DeleteEns(Long id);
}
