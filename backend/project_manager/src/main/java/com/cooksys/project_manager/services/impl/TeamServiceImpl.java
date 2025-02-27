package com.cooksys.project_manager.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cooksys.project_manager.dtos.CredentialsDto;
import com.cooksys.project_manager.dtos.TeamRequestDto;
import com.cooksys.project_manager.dtos.TeamResponseDto;
import com.cooksys.project_manager.entities.Company;
import com.cooksys.project_manager.entities.Project;
import com.cooksys.project_manager.entities.Team;
import com.cooksys.project_manager.entities.User;
import com.cooksys.project_manager.mappers.CompanyMapper;
import com.cooksys.project_manager.mappers.TeamMapper;
import com.cooksys.project_manager.exceptions.*;
import com.cooksys.project_manager.repositories.CompanyRepository;
import com.cooksys.project_manager.repositories.ProjectRepository;
import com.cooksys.project_manager.repositories.TeamRepository;
import com.cooksys.project_manager.repositories.UserRepository;
import com.cooksys.project_manager.services.TeamService;
import com.cooksys.project_manager.services.ValidationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService{
    
    private final TeamRepository teamRepository;
    private final ProjectRepository projectRepository;
    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;
    private final TeamMapper teamMapper;
    private final CompanyMapper companyMapper;
    private final ValidationService validationService;

    // are credentials valid and is this an admin?
    private void hasPermission(CredentialsDto credentialsDto){
        validationService.hasAuthorization(validationService.verifyCredentials(credentialsDto));
    }

    // must find an undeleted team with valid credentials and authority, else throws an error
    private Team validateTeamWithId(Long team_id, CredentialsDto credentialsDto){
        hasPermission(credentialsDto);
        Optional<Team> optionalTeam = teamRepository.findByIdAndIsDeletedFalse(team_id);
        if (!optionalTeam.isPresent()){
            throw new BadRequestException(String.format("Team with id %d is does not exist or is inactive", team_id));
        }
        return optionalTeam.get();
    }

    // finds team with id and doesn't care about auth
    private Team getTeamWithId(Long team_id){
        Optional<Team> optionalTeam = teamRepository.findByIdAndIsDeletedFalse(team_id);
        if (!optionalTeam.isPresent()){
            throw new BadRequestException(String.format("Team with id %d is does not exist or is inactive", team_id));
        }
        return optionalTeam.get();
    }

    // finds user with id and doesn't care about auth
    private User getUserWithId(Long user_id){
        Optional<User> optionalUser = userRepository.findByIdAndIsActiveTrue(user_id);
        if (!optionalUser.isPresent()){
            throw new BadRequestException(String.format("User with id %d is does not exist or is inactive", user_id));
        }
        return optionalUser.get();
    }

    // finds company with id and doesn't care about auth
    private Company getCompanyWithId(Long company_id){
        Optional<Company> optionalCompany = companyRepository.findByIdAndIsDeletedFalse(company_id);
        if (!optionalCompany.isPresent()){
            throw new BadRequestException(String.format("Company with id %d is does not exist or is inactive", company_id));
        }
        return optionalCompany.get();
    }

    @Override
    public List<TeamResponseDto> getAllTeams() {
        return teamMapper.entitiesToDtos(teamRepository.findAllByIsDeletedFalse());
    }

    
    @Override
    public List<TeamResponseDto> getTeamsOfCompany(Long company_id) {
        Company currCompany = getCompanyWithId(company_id);
        return teamMapper.entitiesToDtos(currCompany.getTeams());
    }

    @Override
    public TeamResponseDto getTeam(Long team_id) {
        return teamMapper.entityToResponseDto(getTeamWithId(team_id));
    }

    @Override
    public TeamResponseDto createTeam(TeamRequestDto teamRequestDto) {
        hasPermission(teamRequestDto.getCredentials());
        Team newTeam = teamRepository.save(teamMapper.requestDtoToEntity(teamRequestDto));
        newTeam.setName(teamRequestDto.getName());
        newTeam.setDescription(teamRequestDto.getDescription());
        newTeam.setCompany(teamRequestDto.getCompany());
        return teamMapper.entityToResponseDto(teamRepository.save(newTeam));
    }

    @Override
    public TeamResponseDto updateTeam(Long team_id, TeamRequestDto teamRequestDto) {
        Team currTeam = validateTeamWithId(team_id, teamRequestDto.getCredentials());

        // checking individual fields if they are null, do not replace a non-null field with a null field'
        if (teamRequestDto.getName() != null){
            currTeam.setName(teamRequestDto.getName());
        }
        if (teamRequestDto.getDescription() != null){
            currTeam.setDescription(teamRequestDto.getDescription());
        }
    
        return teamMapper.entityToResponseDto(teamRepository.save(currTeam));
    }

    @Override
    public TeamResponseDto addToTeam(Long team_id, Long user_id, CredentialsDto credentialsDto) {
        Team currTeam = validateTeamWithId(team_id, credentialsDto);
        User currUser = getUserWithId(user_id);
        currTeam.getUsers().add(currUser);

        return teamMapper.entityToResponseDto(teamRepository.save(currTeam));
    }

    @Override
    public TeamResponseDto removeFromTeam(Long team_id, Long user_id, CredentialsDto credentialsDto) {
        Team currTeam = validateTeamWithId(team_id, credentialsDto);
        User currUser = getUserWithId(user_id);
        currTeam.getUsers().remove(currUser);

        return teamMapper.entityToResponseDto(teamRepository.save(currTeam));
    }

    @Override
    public String deleteTeam(Long team_id, CredentialsDto credentialsDto) {
        Team currTeam = validateTeamWithId(team_id, credentialsDto);
        for (Project p : currTeam.getProjects()){
            p.setActive(false);
            projectRepository.save(p);
        }
        currTeam.setDeleted(true);
        teamRepository.save(currTeam);
        return String.format("Team with id %d was deleted successfully", team_id);
    }

    @Override
    public TeamResponseDto restoreTeam(Long team_id, CredentialsDto credentialsDto) {
        Team currTeam = validateTeamWithId(team_id, credentialsDto);
        // don't want to automatically restore projects
        currTeam.setDeleted(false);
        return teamMapper.entityToResponseDto(teamRepository.save(currTeam));
    }
    
}
