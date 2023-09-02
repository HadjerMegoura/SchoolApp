package com.example.subjectmanagement.Repositories;

import com.example.subjectmanagement.Entities.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignantRepo extends JpaRepository<Enseignant,Long> {
}
