package com.example.subjectmanagement.Services;

import com.example.subjectmanagement.Entities.Group;
import com.example.subjectmanagement.Entities.Specialite;
import com.example.subjectmanagement.Entities.Sujet;
import com.example.subjectmanagement.Repositories.GroupRepo;
import com.example.subjectmanagement.Repositories.SujetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SujetServiceImplementation implements SujetService{
    @Autowired
    SujetRepo sujetRepo;
    @Autowired
    GroupRepo groupRepo;

    @Override
    public Sujet addSujet(Sujet sujet) {
        return sujetRepo.save(sujet);
    }

    @Override
    public Boolean deleteSujet(Sujet sujet) {
        sujetRepo.delete(sujet);
        return true;
    }

    @Override
    public Boolean deleteSujetById(Long id) {
        sujetRepo.deleteById(id);
        return null;
    }

    @Override
    public Sujet updateSujet(Long id, Sujet sujet) {
        if (sujetRepo.findById(id).isPresent()) {
            sujet.setId(id);
            sujetRepo.save(sujet);
        }
        return null;
    }

    @Override
    public List<Sujet> getAll() {
        return sujetRepo.findAll();
    }

    @Override
    public Sujet getById(Long id) {
        return sujetRepo.findById(id).get();
    }

    @Override
    public void validSubject(Long id) {
       Sujet sujet= sujetRepo.findById(id).get();
       sujet.setValid(Boolean.TRUE);
        sujetRepo.save(sujet);
    }

    @Override
    public void UndoValidation(Long id) {
       Sujet sujet = sujetRepo.findById(id).get();
       if (sujet.getValid()){sujet.setValid(Boolean.FALSE);
       sujetRepo.save(sujet);}
    }

    @Override
    public List<Sujet> listSujetValid() {
        return sujetRepo.findSujetsByValid(Boolean.TRUE);
    }
    @Override
    public List<Sujet> listSujetNonValid() {
        return sujetRepo.findSujetsByValid(Boolean.FALSE);
    }

    @Override
    public List<Sujet> sujetWithSpecialite(Long idG) {
        Group group = groupRepo.findById(idG).get();
        Specialite sp = group.getSpecialite();
        System.out.println(sp);
        System.out.println(sujetRepo.findSujetsBySpecialite(sp).get(0).getTitre());
        return sujetRepo.findSujetsBySpecialite(sp);

    }

    @Override
    public List<Sujet> sujetWithEns(Long id) {
        return sujetRepo.findSujetsByEnseignant_Id(id);
    }

    @Override
    public List<Sujet> sujetsNonAffectes() {
        return sujetRepo.findSujetsByIsAffected(false);
    }

    public List<Sujet> sujetsAffectes() {
        return sujetRepo.findSujetsByIsAffected(true);
    }
}
