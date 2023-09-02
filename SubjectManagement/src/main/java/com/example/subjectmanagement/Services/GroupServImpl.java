package com.example.subjectmanagement.Services;

import com.example.subjectmanagement.Entities.Group;
import com.example.subjectmanagement.Entities.Sujet;
import com.example.subjectmanagement.Repositories.GroupRepo;
import com.example.subjectmanagement.Repositories.SujetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class GroupServImpl implements GroupService {
    @Autowired
    GroupRepo groupRepo;
    @Autowired
    SujetRepo sujetRepo;


    @Override
    public void choisirSujet(Long idG, Long idS) {
        Group group = groupRepo.findById(idG).get();
        Sujet sujet = sujetRepo.findById(idS).get();
       group.getSujets().add(sujet);
       groupRepo.save(group);

    }

    @Override
    public void undoChoisirSujet(Long idG, Long idS) {
        Group group = groupRepo.findById(idG).get();
        Sujet sujet = sujetRepo.findById(idS).get();

        group.getSujets().remove(sujet);
        groupRepo.save(group);
    }

    @Override
    public Collection<Sujet> getlistSujets(Long idG) {
       Group group = groupRepo.findById(idG).get();
       return group.getSujets();

    }

    @Override
    public Sujet wishForm(Long idS,Long idG, int preriorite) {
        Group group = groupRepo.findById(idG).get();
        Sujet sujet = sujetRepo.findById(idS).get();

        int indexTa3Sujet = group.getSujets().indexOf(sujet);
       // Sujet sujetLiRahFPriorite = group.getSujets().get(preriorite-1);

        if (preriorite-1 == indexTa3Sujet){
            System.out.println("rien a faire");
        }
        else {
            Collections.swap(group.getSujets(),preriorite-1,indexTa3Sujet);
           groupRepo.save(group);
        }
        return group.getSujets().get(0);
    }

    @Override
    public void affecterSujet(Long idG, Long idS) {
        Group group = groupRepo.findById(idG).get();
        Sujet sujet = sujetRepo.findById(idS).get();
        sujet.setIsAffected(Boolean.TRUE);
        sujetRepo.save(sujet);
        group.setSujetAffecté(sujet);
        groupRepo.save(group);
    }


}
