package com.cooksys.project_manager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.project_manager.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
    
  List<Project> findAllByIsActiveTrue();
  Optional<Project> findByIdAndIsActiveTrue(Long id);
  
}
