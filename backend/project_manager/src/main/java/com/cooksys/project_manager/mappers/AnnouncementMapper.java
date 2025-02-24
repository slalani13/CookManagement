package com.cooksys.project_manager.mappers;

import org.mapstruct.Mapper;

import com.cooksys.project_manager.dtos.AnnouncementRequestDto;
import com.cooksys.project_manager.entities.Announcement;

@Mapper(componentModel = "spring")
public interface AnnouncementMapper {
    
    Announcement requestDtoToEntity(AnnouncementRequestDto announcementRequestDto);

    AnnouncementRequestDto entityToReqDto(Announcement announcement);
}
