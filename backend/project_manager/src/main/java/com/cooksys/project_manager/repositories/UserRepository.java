package com.cooksys.project_manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.project_manager.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
