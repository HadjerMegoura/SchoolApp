package com.example.subjectmanagement.Services;

import com.example.subjectmanagement.Entities.Sujet;

import java.util.Collection;
import java.util.List;

public interface GroupService {
    public void choisirSujet(Long idG,Long idS);
    public void undoChoisirSujet(Long idG,Long idS);
    public Collection<Sujet> getlistSujets(Long idG);
    public Sujet wishForm(Long idS,Long idG,int preriorite);
    public void affecterSujet(Long idS,Long idG);
}
