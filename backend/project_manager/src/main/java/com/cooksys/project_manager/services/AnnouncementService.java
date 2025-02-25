package com.cooksys.project_manager.services;

import com.cooksys.project_manager.dtos.AnnouncementResponseDto;

import java.util.List;

public interface AnnouncementService {

    List<AnnouncementResponseDto> getAnnouncementsByCompanyId(Long companyId);

}
