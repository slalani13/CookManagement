package com.cooksys.project_manager.repositories;

import com.cooksys.project_manager.dtos.CredentialsDto;
import com.cooksys.project_manager.entities.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.project_manager.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findByCredentialsUsernameAndCredentialsPassword(String username, String password);

    Optional<User> findById(Long id);

    User findByIdAndIsActiveTrue(Long id);
}
