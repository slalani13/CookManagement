package com.cooksys.project_manager.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.project_manager.dtos.AnnouncementRequestDto;
import com.cooksys.project_manager.dtos.AnnouncementResponseDto;
import com.cooksys.project_manager.services.AnnouncementService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/announcements")

public class AnnouncementController {
    private final AnnouncementService announcementService;

    @GetMapping("/{id}")
    public List<AnnouncementResponseDto> getAnnouncements(@PathVariable Long id) {
        return announcementService.getAnnouncementsByCompanyId(id);
    }

    @PostMapping
    public AnnouncementResponseDto createAnnouncement(@RequestBody AnnouncementRequestDto announcementRequestDto) {
        return announcementService.createAnnouncement(announcementRequestDto);
    }

}
