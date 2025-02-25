package com.cooksys.project_manager.controllers;

import java.util.List;

import com.cooksys.project_manager.dtos.AnnouncementRequestDto;
import org.springframework.web.bind.annotation.*;

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
    public AnnouncementResponseDto createAnnouncement(@RequestBody AnnouncementRequestDto announcementRequestDto) {
        return announcementService.createAnnouncement(announcementRequestDto);
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
