package com.example.subjectmanagement.Repositories;

import com.example.subjectmanagement.Entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RestResource
public interface GroupRepo extends JpaRepository<Group,Long> {

}
