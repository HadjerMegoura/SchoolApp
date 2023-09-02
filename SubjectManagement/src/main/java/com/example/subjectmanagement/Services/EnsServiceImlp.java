package com.example.subjectmanagement.Services;

import com.example.subjectmanagement.Entities.Enseignant;
import com.example.subjectmanagement.Repositories.EnseignantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EnsServiceImlp implements EnseignantService{
    @Autowired
    EnseignantRepo enseignantRepo;

    @Override
    public List<Enseignant> getAllEns() {
        return enseignantRepo.findAll();
    }

    @Override
    public Enseignant DetailEnseignant(Long id) {
        return enseignantRepo.findById(id).get();
    }

    @Override
    public Enseignant UpdateEns(Enseignant ens, Long id) {
        if (enseignantRepo.findById(id).isPresent()){
            ens.setId(id);
            enseignantRepo.save(ens);
        }
        return null;
    }

    @Override
    public void DeleteEns(Long id) {
         enseignantRepo.deleteById(id);
    }
}
