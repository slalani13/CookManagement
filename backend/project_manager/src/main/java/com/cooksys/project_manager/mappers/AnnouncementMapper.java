package com.cooksys.project_manager.mappers;

import org.mapstruct.Mapper;

import com.cooksys.project_manager.dtos.AnnouncementRequestDto;
import com.cooksys.project_manager.dtos.AnnouncementResponseDto;
import com.cooksys.project_manager.entities.Announcement;

@Mapper(componentModel = "spring", uses = { UserMapper.class, ProfileMapper.class})
public interface AnnouncementMapper {
    
    Announcement requestDtoToEntity(AnnouncementRequestDto announcementRequestDto);

    AnnouncementResponseDto entityToResponseDto(Announcement announcement);
}
