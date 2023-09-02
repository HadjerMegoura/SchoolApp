package com.example.subjectmanagement.Services;

import com.example.subjectmanagement.Entities.Specialite;
import com.example.subjectmanagement.Entities.Sujet;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.security.auth.Subject;
import java.util.List;


public interface SujetService {
    Sujet addSujet(Sujet sujet);
    Boolean deleteSujet(Sujet sujet);
    Boolean deleteSujetById(Long id);
    Sujet updateSujet(Long id,Sujet sujet);
    List<Sujet> getAll();
    Sujet getById(Long id);
    void validSubject(Long id);
    void UndoValidation(Long id);
    List<Sujet> listSujetValid();
    List<Sujet> listSujetNonValid();
    List<Sujet> sujetWithSpecialite(Long idS);
    List<Sujet> sujetWithEns(Long id);
    List<Sujet> sujetsNonAffectes();
    List<Sujet> sujetsAffectes();

}
