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

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final TeamMapper teamMapper;
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;
    private final CredentialsMapper credentialsMapper;

    // must find an undeleted project with valid credentials and authority, else throws an error
    private Project validateProjectWithId(Long project_id, CredentialsDto credentialsDto){
        hasAuthorization(verifyCredentials(credentialsDto));
        Optional<Project> optionalProject = projectRepository.findByIdAndIsActiveTrue(project_id);
        if (!optionalProject.isPresent()){
            throw new BadRequestException(String.format("Project with id %s is does not exist or is inactive", project_id));
        }
        return optionalProject.get();
    }

    // finds undeleted projects too and doesn't care about auth
    private Project getProjectWithId(Long project_id){
        Optional<Project> optionalProject = projectRepository.findById(project_id);
        if (!optionalProject.isPresent()){
            throw new BadRequestException(String.format("Project with id %s is does not exist or is inactive", project_id));
        }
        return optionalProject.get();
    }

    // finds undeleted projects too and doesn't care about auth
    private Team getTeamWithId(Long team_id){
        Optional<Team> optionalTeam = teamRepository.findByIdAndIsDeletedFalse(team_id);
        if (!optionalTeam.isPresent()){
            throw new BadRequestException(String.format("Team with id %s is does not exist or is inactive", team_id));
        }
        return optionalTeam.get();
    }

    // verify that the user has admin privilege
    private User hasAuthorization(User user){
        if (!user.isAdmin()){
            throw new NotAuthorizedException(String.format("User with username %s is not an admin", user.getCredentials().getUsername()));
        }
        return user;
    }

    // verify that the credentials match the username and the user is active
    private User verifyCredentials(CredentialsDto credentialsDto){
        isValidCredentials(credentialsDto);
        Optional<User> optionalUser = userRepository.findByCredentialsUsernameAndIsActiveTrue(credentialsDto.getUsername());
        if (!optionalUser.isPresent()){
            throw new BadRequestException(String.format("User with username %s is not present", optionalUser.get().getCredentials().getUsername()));
        }
        if (!optionalUser.get().isActive()){
            throw new BadRequestException(String.format("User with username %s was deactivated", optionalUser.get().getCredentials().getUsername()));
        }
        return optionalUser.get();
    }

    // checks whether the credentials request has valid fields
    private void isValidCredentials(CredentialsDto credentialsRequestDto){
        if (credentialsRequestDto == null){
        throw new BadRequestException(String.format("Credentials are missing in user request"));
        }
        if (credentialsRequestDto.getUsername() == null || credentialsRequestDto.getPassword() == null){
        throw new BadRequestException(String.format("Either username or password are missing in credentials request"));
        }
    }


    @Override   
    public List<ProjectResponseDto> getAllProjects() {
        return projectMapper.entitiesToDtos(projectRepository.findAllByIsActiveTrue());
    }

    @Override
    public ProjectResponseDto createProject(ProjectRequestDto projectRequestDto, CredentialsDto credentialsDto) {
        hasAuthorization(verifyCredentials(credentialsDto));
        Project newProject = projectRepository.save(projectMapper.requestDtoToEntity(projectRequestDto));
        newProject.setActive(false);
        newProject.setName(projectRequestDto.getName());
        newProject.setDescription(projectRequestDto.getDescription());
        newProject.setTeam(teamMapper.responseDtoToEntity(projectRequestDto.getTeam()));
        return projectMapper.entityToResponseDto(projectRepository.save(newProject));
    }

    @Override
    public ProjectResponseDto updateProject(Long project_id, ProjectRequestDto projectRequestDto,
            CredentialsDto credentialsDto) {
        
        Project currProject = validateProjectWithId(project_id, credentialsDto);

        // checking individual fields if they are null, do not replace a non-null field with a null field'
        if (projectRequestDto.getName() != null){
            currProject.setName(projectRequestDto.getName());
        }
        if (projectRequestDto.getDescription() != null){
            currProject.setDescription(projectRequestDto.getDescription());
        }
        if (projectRequestDto.getTeam() != null){
            currProject.setTeam(teamMapper.responseDtoToEntity(projectRequestDto.getTeam()));
        } 
        currProject.setActive(projectRequestDto.isActive());
    
        return projectMapper.entityToResponseDto(projectRepository.save(currProject));
    }

    @Override
    public ProjectResponseDto getProject(Long project_id) {
        return projectMapper.entityToResponseDto(projectRepository.save(getProjectWithId(project_id)));
    }

    @Override
    public List<ProjectResponseDto> getCompanyProjectsOfTeam(Long team_id) {
        Team team = getTeamWithId(team_id);
        List<Project> projects = new ArrayList<>();
        for (Project p : projectRepository.findAllByIsActiveTrue()) {
            if (p.getTeam().equals(team) && p.isActive()){
                projects.add(p);
            }
        }
        return projectMapper.entitiesToDtos(projects);
    }
    
}
