package com.example.subjectmanagement.Services;

import com.example.subjectmanagement.Entities.Compte;
import com.example.subjectmanagement.Entities.Specialite;

import java.util.List;

public interface CompteService {
    Compte addUser(Compte user, Specialite sp);
    void deleteUser(Long id);
    Compte updateUser(Long id, Compte user,Specialite sp);
    List<Compte> getAllUsers();
}
