package com.cooksys.project_manager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.project_manager.entities.Project;
import com.cooksys.project_manager.entities.Team;


@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{

    Optional<Team> findByIdAndIsDeletedFalse(Long id);
    
}
