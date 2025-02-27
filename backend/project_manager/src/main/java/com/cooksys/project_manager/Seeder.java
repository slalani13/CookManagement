package com.cooksys.project_manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cooksys.project_manager.entities.Announcement;
import com.cooksys.project_manager.entities.Company;
import com.cooksys.project_manager.entities.Credentials;
import com.cooksys.project_manager.entities.Profile;
import com.cooksys.project_manager.entities.Project;
import com.cooksys.project_manager.entities.Team;
import com.cooksys.project_manager.entities.User;
import com.cooksys.project_manager.repositories.AnnouncementRepository;
import com.cooksys.project_manager.repositories.CompanyRepository;
import com.cooksys.project_manager.repositories.ProjectRepository;
import com.cooksys.project_manager.repositories.TeamRepository;
import com.cooksys.project_manager.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Seeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private final TeamRepository teamRepository;
    private final ProjectRepository projectRepository;
    private final AnnouncementRepository announcementRepository;

    @Override
    public void run(String... args) throws Exception {
        // Create Credentials
        Credentials cred1 = new Credentials();
        cred1.setUsername("john_doe");
        cred1.setPassword("password");

        Credentials cred2 = new Credentials();
        cred2.setUsername("jane_smith");
        cred2.setPassword("password");

        Credentials cred3 = new Credentials();
        cred3.setUsername("alice_wonder");
        cred3.setPassword("securepass");

        Credentials cred4 = new Credentials();
        cred4.setUsername("bob_builder");
        cred4.setPassword("strongpass");

        // Create Profiles
        Profile profile1 = new Profile();
        profile1.setFirstName("John");
        profile1.setLastName("Doe");
        profile1.setEmail("john@example.com");
        profile1.setPhone("1234567890");

        Profile profile2 = new Profile();
        profile2.setFirstName("Jane");
        profile2.setLastName("Smith");
        profile2.setEmail("jane@example.com");
        profile2.setPhone("0987654321");

        Profile profile3 = new Profile();
        profile3.setFirstName("Alice");
        profile3.setLastName("Wonder");
        profile3.setEmail("alice@example.com");
        profile3.setPhone("1112223333");

        Profile profile4 = new Profile();
        profile4.setFirstName("Bob");
        profile4.setLastName("Builder");
        profile4.setEmail("bob@example.com");
        profile4.setPhone("4445556666");

        // Create Users
        User user1 = new User();
        user1.setCredentials(cred1);
        user1.setProfile(profile1);
        user1.setActive(true);
        user1.setAdmin(false);
        user1.setStatus("active");

        User user2 = new User();
        user2.setCredentials(cred2);
        user2.setProfile(profile2);
        user2.setActive(true);
        user2.setAdmin(true);
        user2.setStatus("active");

        User user3 = new User();
        user3.setCredentials(cred3);
        user3.setProfile(profile3);
        user3.setActive(true);
        user3.setAdmin(false);
        user3.setStatus("active");

        User user4 = new User();
        user4.setCredentials(cred4);
        user4.setProfile(profile4);
        user4.setActive(true);
        user4.setAdmin(false);
        user4.setStatus("active");

        userRepository.saveAll(List.of(user1, user2, user3, user4));

        // Create Company
        Company company = new Company();
        company.setName("TechCorp");
        company.setDescription("A leading tech company");
        companyRepository.save(company);

        // Assign Users to Company
        user1.setCompanies(new ArrayList<>(List.of(company)));
        user2.setCompanies(new ArrayList<>(List.of(company)));
        user3.setCompanies(new ArrayList<>(List.of(company)));
        user4.setCompanies(new ArrayList<>(List.of(company)));
        userRepository.saveAll(List.of(user1, user2, user3, user4));

        // Create Teams
        Team team1 = new Team();
        team1.setName("Development Team");
        team1.setDescription("Handles all development");
        team1.setCompany(company.getId());
        team1.setUsers(new ArrayList<>(List.of(user1, user2)));

        Team team2 = new Team();
        team2.setName("QA Team");
        team2.setDescription("Ensures quality");
        team2.setCompany(company.getId());
        team2.setUsers(new ArrayList<>(List.of(user3, user4)));

        teamRepository.saveAll(List.of(team1, team2));

        // Create Projects
        Project project1 = new Project();
        project1.setName("Project Alpha");
        project1.setDescription("An innovative project");
        project1.setActive(true);
        project1.setTeam(team1.getId());

        Project project2 = new Project();
        project2.setName("Project Beta");
        project2.setDescription("A high-priority project");
        project2.setActive(true);
        project2.setTeam(team2.getId());

        projectRepository.saveAll(List.of(project1, project2));

        // Create Announcements
        Announcement announcement1 = new Announcement();
        announcement1.setDate(new java.sql.Timestamp(System.currentTimeMillis()));
        announcement1.setTitle("Launch Event");
        announcement1.setMessage("We are launching soon!");
        announcement1.setCompany(company);
        announcement1.setAuthor(user1);

        Announcement announcement2 = new Announcement();
        announcement2.setDate(new java.sql.Timestamp(System.currentTimeMillis()));
        announcement2.setTitle("New Project");
        announcement2.setMessage("We have started working on a new project!");
        announcement2.setCompany(company);
        announcement2.setAuthor(user2);

        announcementRepository.saveAll(List.of(announcement1, announcement2));
    }
}
