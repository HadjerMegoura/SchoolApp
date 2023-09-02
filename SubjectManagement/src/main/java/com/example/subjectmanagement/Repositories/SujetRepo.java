package com.example.subjectmanagement.Repositories;

import com.example.subjectmanagement.Entities.Specialite;
import com.example.subjectmanagement.Entities.Sujet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.security.SecurityPermission;
import java.util.List;

@RestResource
public interface SujetRepo extends JpaRepository<Sujet,Long> {
    List<Sujet> findSujetsByValid(Boolean b);
    List<Sujet> findSujetsBySpecialite(Specialite sp);
    List<Sujet> findSujetsByEnseignant_Id(Long idE);
    List<Sujet> findSujetsByIsAffected(Boolean b);
}
