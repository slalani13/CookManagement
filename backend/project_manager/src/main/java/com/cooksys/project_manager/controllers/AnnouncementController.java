package com.cooksys.project_manager.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.project_manager.dtos.AnnouncementResponseDto;
import com.cooksys.project_manager.services.AnnouncementService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/announcements")

public class AnnouncementController {
    private final AnnouncementService announcementService;

    @GetMapping("/{id}/announcements")
    public List<AnnouncementResponseDto> getAnnouncements(@PathVariable Long id) {
        return announcementService.getAnnouncementsByCompanyId(id);
    }

    @GetMapping
    public AnnouncementResponseDto getAnnouncement() {
        return null;
    }

    @PostMapping("/announcement")
    public AnnouncementResponseDto createAnnouncement() {
        return null;
    }

    @PatchMapping("/announcement/update")
    public AnnouncementResponseDto updateAnnouncement() {
        return null;
    }
    
    @DeleteMapping
    public AnnouncementResponseDto deleteAnnouncement() {
        return null;
    }

}
