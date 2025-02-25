package com.cooksys.project_manager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.project_manager.entities.Company;
import com.cooksys.project_manager.entities.User;

public interface CompanyRepository extends JpaRepository<Company, Long>{

    List<User> findAllByIdAndIsDeletedFalse(Long id);

    List<Company> findAllByIsDeletedFalse();

    Optional<Company> findByIdAndIsDeletedFalse(Long id);
}
