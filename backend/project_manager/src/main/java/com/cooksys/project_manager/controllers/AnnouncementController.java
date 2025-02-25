package com.cooksys.project_manager.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.project_manager.dtos.AnnouncementResponseDto;
import com.cooksys.project_manager.services.AnnouncementService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")

public class AnnouncementController {
    private final AnnouncementService announcementService;

    @GetMapping("/{id}/announcements")
    public List<AnnouncementResponseDto> getAnnouncements() {
        return null;
    }

}
