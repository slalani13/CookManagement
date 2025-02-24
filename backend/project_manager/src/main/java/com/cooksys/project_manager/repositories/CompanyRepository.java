package com.cooksys.project_manager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.project_manager.entities.Company;
import com.cooksys.project_manager.entities.User;

public interface CompanyRepository extends JpaRepository<Company, Long>{

    List<User> findAllByIdAndDeletedFalse(Long id);
}
