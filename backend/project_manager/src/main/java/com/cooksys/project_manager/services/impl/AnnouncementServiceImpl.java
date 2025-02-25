package com.cooksys.project_manager.services.impl;

import com.cooksys.project_manager.dtos.AnnouncementRequestDto;
import com.cooksys.project_manager.dtos.AnnouncementResponseDto;
import com.cooksys.project_manager.entities.Announcement;
import com.cooksys.project_manager.entities.Company;
import com.cooksys.project_manager.entities.User;
import com.cooksys.project_manager.exceptions.NotFoundException;
import com.cooksys.project_manager.mappers.AnnouncementMapper;
import com.cooksys.project_manager.repositories.AnnouncementRepository;
import com.cooksys.project_manager.repositories.CompanyRepository;
import com.cooksys.project_manager.repositories.UserRepository;
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
    private final UserRepository userRepository;

    @Override
    public List<AnnouncementResponseDto> getAnnouncementsByCompanyId(Long companyId) {
        Optional<Company>optionalCompany = companyRepository.findById(companyId);
        if (optionalCompany.isEmpty()) {
            throw new NotFoundException("Company not found");
        }

        Company company = optionalCompany.get();
        List<Announcement> announcements = announcementRepository.findByCompanyAndIsDeletedFalse(company);
        return announcements.stream()
                .map(announcementMapper::entityToResponseDto)
                .toList();
    }

    @Override
    public AnnouncementResponseDto createAnnouncement(AnnouncementRequestDto announcementRequestDto) {
        if (announcementRequestDto.getTitle() == null) {
            throw new NotFoundException("Title not found");
        }
        if (announcementRequestDto.getMessage() == null) {
            throw new NotFoundException("Body not found");
        }
        User user = userRepository.findById(announcementRequestDto.getAuthorId())
                .orElseThrow(() -> new NotFoundException("Author not found"));
        Company company = companyRepository.findById(announcementRequestDto.getCompanyId())
                .orElseThrow(() -> new NotFoundException("Company not found"));

        Announcement newAnnouncement = new Announcement();
        newAnnouncement.setAuthor(user);
        newAnnouncement.setCompany(company);
        newAnnouncement.setMessage(announcementRequestDto.getMessage());
        newAnnouncement.setTitle(announcementRequestDto.getTitle());
        newAnnouncement.setDeleted(false);

        return announcementMapper.entityToResponseDto(announcementRepository.saveAndFlush(newAnnouncement));
    }

}
