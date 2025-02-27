package com.cooksys.project_manager.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cooksys.project_manager.dtos.CredentialsDto;
import com.cooksys.project_manager.dtos.ProjectRequestDto;
import com.cooksys.project_manager.dtos.ProjectResponseDto;
import com.cooksys.project_manager.dtos.UserRequestDto;
import com.cooksys.project_manager.entities.Project;
import com.cooksys.project_manager.entities.Team;
import com.cooksys.project_manager.entities.User;
import com.cooksys.project_manager.exceptions.*;
import com.cooksys.project_manager.mappers.CredentialsMapper;
import com.cooksys.project_manager.mappers.ProjectMapper;
import com.cooksys.project_manager.mappers.TeamMapper;
import com.cooksys.project_manager.repositories.ProjectRepository;
import com.cooksys.project_manager.repositories.TeamRepository;
import com.cooksys.project_manager.repositories.UserRepository;
import com.cooksys.project_manager.services.ProjectService;
import com.cooksys.project_manager.services.ValidationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final TeamMapper teamMapper;
    private final TeamRepository teamRepository;
    private final ValidationService validationService;

    // are credentials valid and is this an admin?
    private void hasPermission(CredentialsDto credentialsDto){
        validationService.hasAuthorization(validationService.verifyCredentials(credentialsDto));
    }

    // must find an undeleted project with valid credentials and authority, else throws an error
    private Project validateProjectWithId(Long project_id, CredentialsDto credentialsDto){
        hasPermission(credentialsDto);
        Optional<Project> optionalProject = projectRepository.findByIdAndIsActiveTrue(project_id);
        if (!optionalProject.isPresent()){
            throw new BadRequestException(String.format("Project with id %d is does not exist or is inactive", project_id));
        }
        return optionalProject.get();
    }

    // finds project with id and doesn't care about auth
    private Project getProjectWithId(Long project_id){
        Optional<Project> optionalProject = projectRepository.findById(project_id);
        if (!optionalProject.isPresent()){
            throw new BadRequestException(String.format("Project with id %d is does not exist or is inactive", project_id));
        }
        return optionalProject.get();
    }

    // finds team with id and doesn't care about auth
    private Team getTeamWithId(Long team_id){
        Optional<Team> optionalTeam = teamRepository.findByIdAndIsDeletedFalse(team_id);
        if (!optionalTeam.isPresent()){
            throw new BadRequestException(String.format("Team with id %d is does not exist or is inactive", team_id));
        }
        return optionalTeam.get();
    }

    @Override   
    public List<ProjectResponseDto> getAllProjects() {
        return projectMapper.entitiesToDtos(projectRepository.findAllByIsActiveTrue());
    }

    @Override
    public ProjectResponseDto getProject(Long project_id) {
        return projectMapper.entityToResponseDto(projectRepository.save(getProjectWithId(project_id)));
    }

    @Override
    public ProjectResponseDto createProject(Long team_id, ProjectRequestDto projectRequestDto) {
        hasPermission(projectRequestDto.getCredentials());
        Team currTeam = getTeamWithId(team_id);
        Project newProject = projectRepository.save(projectMapper.requestDtoToEntity(projectRequestDto));
        newProject.setActive(true);
        newProject.setName(projectRequestDto.getName());
        newProject.setDescription(projectRequestDto.getDescription());
        newProject.setTeam(projectRequestDto.getTeam());
        currTeam.getProjects().add(newProject);
        teamRepository.save(currTeam);
        return projectMapper.entityToResponseDto(projectRepository.save(newProject));
    }

    @Override
    public ProjectResponseDto updateProject(Long project_id, ProjectRequestDto projectRequestDto) {
        
        hasPermission(projectRequestDto.getCredentials());
        Project currProject = getProjectWithId(project_id);

        // checking individual fields if they are null, do not replace a non-null field with a null field'
        if (projectRequestDto.getName() != null){
            currProject.setName(projectRequestDto.getName());
        }
        if (projectRequestDto.getDescription() != null){
            currProject.setDescription(projectRequestDto.getDescription());
        }
        currProject.setActive(projectRequestDto.isActive());
    
        return projectMapper.entityToResponseDto(projectRepository.save(currProject));
    }

    @Override
    public List<ProjectResponseDto> getCompanyProjectsOfTeam(Long team_id) {
        Team team = getTeamWithId(team_id);
        List<Project> projects = new ArrayList<>();
        for (Project p : team.getProjects()) {
            if (p.isActive()){
                projects.add(p);
            }
        }
        return projectMapper.entitiesToDtos(projects);
    }

    @Override
    public String fullyDeleteProject(Long project_id, CredentialsDto credentialsDto) {
        Project currProject = validateProjectWithId(project_id, credentialsDto);
        Team currTeam = getTeamWithId(currProject.getTeam());
        currTeam.getProjects().remove(currProject);
        teamRepository.save(currTeam);
        projectRepository.delete(currProject);
        return String.format("Project with id %d was deleted successfully", project_id);
    }
    
}
