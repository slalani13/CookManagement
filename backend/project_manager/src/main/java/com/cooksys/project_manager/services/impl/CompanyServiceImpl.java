package com.cooksys.project_manager.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.cooksys.project_manager.services.CompanyService;
import com.cooksys.project_manager.dtos.AnnouncementResponseDto;
import com.cooksys.project_manager.dtos.CompanyRequestDto;
import com.cooksys.project_manager.dtos.CompanyResponseDto;
import com.cooksys.project_manager.dtos.FullUserDto;
import com.cooksys.project_manager.dtos.TeamRequestDto;
import com.cooksys.project_manager.dtos.UserResponseDto;
import com.cooksys.project_manager.entities.Company;
import com.cooksys.project_manager.entities.Team;
import com.cooksys.project_manager.entities.User;
import com.cooksys.project_manager.exceptions.BadRequestException;
import com.cooksys.project_manager.exceptions.NotFoundException;
import com.cooksys.project_manager.mappers.CompanyMapper;
import com.cooksys.project_manager.mappers.TeamMapper;
import com.cooksys.project_manager.mappers.UserMapper;
import com.cooksys.project_manager.repositories.CompanyRepository;
import com.cooksys.project_manager.repositories.TeamRepository;
import com.cooksys.project_manager.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final TeamMapper teamMapper;
    private final TeamRepository teamRepository;



    // HELPER 

    public Company validateCompanyId(Long id) {
        Optional<Company> company = companyRepository.findByIdAndIsDeletedFalse(id);
        if (company.isEmpty()) {
            throw new NotFoundException("No company with id: " + id);
        }
        return company.get();
    }

    public void validateCompany(CompanyRequestDto companyRequestDto) {
        String name = companyRequestDto.getName();
        if (name.isEmpty()) {
            throw new BadRequestException("A company must have a name");
        }
    }


    // Retrieves a list of all active users that work for the given company. 
    // If the company id provided does not match an active company in the database,
    // an error should be sent in lieu of a response.
    @Override
    public List<FullUserDto> getUsers(Long id) {
        Company company = validateCompanyId(id);
        Set<User> users = new HashSet<>();
        company.getUsers().forEach(users::add);
        users.removeIf(user -> !user.isActive());
        return userMapper.entitiesToDto(users);
    }

    @Override
    public List<CompanyResponseDto> getCompanies() {
        return companyMapper.entitiesToDto(companyRepository.findAllByIsDeletedFalse());
    }

    @Override
    public CompanyResponseDto getCompany(Long id) {
        Company company = validateCompanyId(id);
        return companyMapper.entityToDto(company);
    }

    @Override
    public CompanyResponseDto createCompany(CompanyRequestDto companyRequestDto) {
        validateCompany(companyRequestDto);
        Company newCompany = new Company();
        newCompany.setName(companyRequestDto.getName());
        newCompany.setDescription(companyRequestDto.getDescription());
        newCompany.setTeams(teamMapper.dtosToEntities(companyRequestDto.getTeams()));
        newCompany.setUsers(userMapper.dtosToEntities(companyRequestDto.getUsers()));

        return companyMapper.entityToDto(companyRepository.saveAndFlush(newCompany));

    }

    @Override
    public CompanyResponseDto updateCompany(Long id, CompanyRequestDto companyRequestDto) {
        Company companyToUpdate = validateCompanyId(id);
        List<Team> teams = teamMapper.dtosToEntities(companyRequestDto.getTeams());
        List<User> users = userMapper.dtosToEntities(companyRequestDto.getUsers());
        
        if (!companyRequestDto.getName().isEmpty()) {
            companyToUpdate.setName(companyRequestDto.getName());
        }
        if (!companyRequestDto.getDescription().isEmpty()) {
            companyToUpdate.setDescription(companyRequestDto.getDescription());
        }

        companyToUpdate.getTeams().addAll(teams);
        companyToUpdate.getUsers().addAll(users);

        return companyMapper.entityToDto(companyRepository.saveAndFlush(companyToUpdate));
        
    }

    @Override
    public CompanyResponseDto deleteCompany(Long id) {

        Company companyToDelete = validateCompanyId(id);
        
        if (!companyToDelete.isDeleted()) {
            companyToDelete.setDeleted(true);
            for (Team team : companyToDelete.getTeams()) {
                team.setDeleted(true);
                teamRepository.save(team);
            }
        }

        return companyMapper.entityToDto(companyRepository.saveAndFlush(companyToDelete));
    } 

}
