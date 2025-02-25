package com.cooksys.project_manager.services.impl;

import com.cooksys.project_manager.dtos.AnnouncementResponseDto;
import com.cooksys.project_manager.entities.Announcement;
import com.cooksys.project_manager.entities.Company;
import com.cooksys.project_manager.exceptions.NotFoundException;
import com.cooksys.project_manager.mappers.AnnouncementMapper;
import com.cooksys.project_manager.repositories.AnnouncementRepository;
import com.cooksys.project_manager.repositories.CompanyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cooksys.project_manager.services.AnnouncementService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService {
    private final AnnouncementRepository announcementRepository;
    private final CompanyRepository companyRepository;
    private final AnnouncementMapper announcementMapper;

    @Override
    public List<AnnouncementResponseDto> getAnnouncementsByCompanyId(Long companyId) {
        Optional<Company>optionalCompany = companyRepository.findById(companyId);
        if (optionalCompany.isEmpty()) {
            throw new NotFoundException("Company not found");
        }

        Company company = optionalCompany.get();
        List<Announcement> announcements = announcementRepository.findByCompany(company);
//        List<Announcement> announcements = announcementRepository.findByCompanyAndIsDeletedFalse(company);
        return announcements.stream()
                .map(announcementMapper::entityToResponseDto)
                .toList();
    }

}
