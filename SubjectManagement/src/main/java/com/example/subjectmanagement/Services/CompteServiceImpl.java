package com.example.subjectmanagement.Services;

import com.example.subjectmanagement.Entities.*;
import com.example.subjectmanagement.Repositories.EnseignantRepo;
import com.example.subjectmanagement.Repositories.GroupRepo;
import com.example.subjectmanagement.Repositories.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteServiceImpl implements CompteService {
    @Autowired
    userRepo userRepo;
    @Autowired
    GroupRepo groupRepo;
    @Autowired
    EnseignantRepo enseignantRepo;
    @Override
    public Compte addUser(Compte compte, Specialite sp) {
        userRepo.save(compte);
        if (compte.getType() == Type.student) {
            Group group = new Group();
            group.setId(compte.getId());
            group.setSpecialite(sp);
            group.setCompte(compte);
            groupRepo.save(group);
        }

        else if (compte.getType() == Type.teacher){
            Enseignant enseignant = new Enseignant();
            enseignant.setId(compte.getId());
            enseignant.setCompte(compte);
            enseignantRepo.save(enseignant);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {

        Compte user = userRepo.findById(id).get();
        if (user.getType()== Type.student){
            groupRepo.deleteById(id);
        }
        else if (user.getType() == Type.teacher){
            enseignantRepo.deleteById(id);
        }
        userRepo.deleteById(id);
    }

    @Override
    public Compte updateUser(Long id, Compte user,Specialite sp) {
        if (userRepo.findById(id).isPresent()) {
            user.setId(id);
            userRepo.save(user);
            if (user.getType() == Type.student) {
              Group group = groupRepo.findById(user.getId()).get();
              group.setSpecialite(sp);
              groupRepo.save(group);
            }
        }
        return user;
    }

    @Override
    public List<Compte> getAllUsers() {
        return userRepo.findAll();
    }
}
