package com.example.subjectmanagement.Repositories;

import com.example.subjectmanagement.Entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface userRepo extends JpaRepository<Compte,Long> {
}
