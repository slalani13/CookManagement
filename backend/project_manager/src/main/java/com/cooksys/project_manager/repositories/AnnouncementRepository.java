package com.cooksys.project_manager.repositories;

import com.cooksys.project_manager.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.project_manager.entities.Announcement;

import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long>{
//    List<Announcement> findByCompanyAndDeletedFalse(Company company);

    List<Announcement> findByCompany(Company company);

}
