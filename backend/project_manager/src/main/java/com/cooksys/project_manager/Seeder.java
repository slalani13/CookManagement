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

        Credentials cred5 = new Credentials();
        cred5.setUsername("mr_meeseeks");
        cred5.setPassword("password");

        Credentials cred6 = new Credentials();
        cred6.setUsername("hackerman");
        cred6.setPassword("password");

        Credentials cred7 = new Credentials();
        cred7.setUsername("fedex_bossman");
        cred7.setPassword("password");

        Credentials cred8 = new Credentials();
        cred8.setUsername("red_stapler");
        cred8.setPassword("password");

        Credentials cred9 = new Credentials();
        cred9.setUsername("paolo");
        cred9.setPassword("password");

        Credentials cred10 = new Credentials();
        cred9.setUsername("rishi");
        cred9.setPassword("password");

        Credentials cred11 = new Credentials();
        cred9.setUsername("shariq");
        cred9.setPassword("password");

        Credentials cred12= new Credentials();
        cred9.setUsername("gabriel");
        cred9.setPassword("password");

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

        Profile profile5 = new Profile();
        profile5.setFirstName("Mr");
        profile5.setLastName("Meeseeks");
        profile5.setEmail("meseeks@cube.com");
        profile5.setPhone("7778889999");

        Profile profile6 = new Profile();
        profile6.setFirstName("Hack");
        profile6.setLastName("Erman");
        profile6.setEmail("anonymous@anon.com");
        profile6.setPhone("0001112222");

        Profile profile7 = new Profile();
        profile7.setFirstName("FedEx");
        profile7.setLastName("Bossman");
        profile7.setEmail("ups@fedex.com");
        profile7.setPhone("1231231234");

        Profile profile8 = new Profile();
        profile8.setFirstName("Red");
        profile8.setLastName("Stapler");
        profile8.setEmail("red@initech.net");
        profile8.setPhone("5555555555");

        Profile profile9 = new Profile();
        profile9.setFirstName("Paolo");  // Should be profile9
        profile9.setLastName("ALberca"); // Should be profile9
        profile9.setEmail("paolo@cooksys.com"); // Should be profile9
        profile9.setPhone("5555555555"); // Should be profile9

        Profile profile10 = new Profile();
        profile10.setFirstName("Rishi");
        profile10.setLastName("Jammalamadaka");
        profile10.setEmail("Rishi@cooksys.com");
        profile10.setPhone("5555555555");

        Profile profile11 = new Profile();
        profile11.setFirstName("Shariq");
        profile11.setLastName("Lalni");
        profile11.setEmail("shariq@cooksys.com");
        profile11.setPhone("5555555555");

        Profile profile12 = new Profile();
        profile12.setFirstName("Gabriel");
        profile12.setLastName("Quezada");
        profile12.setEmail("gabriel@cooksys.com");
        profile12.setPhone("5555555555");

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

        User user5 = new User();
        user5.setCredentials(cred5);
        user5.setProfile(profile5);
        user5.setActive(true);
        user5.setAdmin(true);
        user5.setStatus("active");

        User user6 = new User();
        user6.setCredentials(cred6);
        user6.setProfile(profile6);
        user6.setActive(true);
        user6.setAdmin(true);
        user6.setStatus("active");

        User user7 = new User();
        user7.setCredentials(cred7);
        user7.setProfile(profile7);
        user7.setActive(true);
        user7.setAdmin(true);
        user7.setStatus("active");

        User user8 = new User();
        user8.setCredentials(cred8);
        user8.setProfile(profile8);
        user8.setActive(true);
        user8.setAdmin(false);
        user8.setStatus("inactive");

        User user9 = new User();
        user9.setCredentials(cred9);
        user9.setProfile(profile9);
        user9.setActive(true);
        user9.setAdmin(true);
        user9.setStatus("active");

        User user10 = new User();
        user10.setCredentials(cred10);  // Fixed
        user10.setProfile(profile10);   // Fixed
        user10.setActive(true);         // Fixed
        user10.setAdmin(true);          // Fixed
        user10.setStatus("active");

        User user11 = new User();
        user11.setCredentials(cred11);  // Fixed
        user11.setProfile(profile11);   // Fixed
        user11.setActive(true);         // Fixed
        user11.setAdmin(true);          // Fixed
        user11.setStatus("active");     // Fixed

        User user12 = new User();
        user12.setCredentials(cred12);  // Fixed
        user12.setProfile(profile12);   // Fixed
        user12.setActive(true);         // Fixed
        user12.setAdmin(true);          // Fixed
        user12.setStatus("active");     // Fixed


        userRepository.saveAll(List.of(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11, user12));

        // Create Company
        Company company = new Company();
        company.setName("CookSys");
        company.setDescription("A leading tech company");
        companyRepository.save(company);

        Company company2 = new Company();
        company2.setName("Hooli");
        company2.setDescription("A Gavin Belson company");
        companyRepository.save(company2);

        Company company3 = new Company();
        company3.setName("Pied Piper");
        company3.setDescription("A Richard Hendricks company");
        companyRepository.save(company3);

        Company company4 = new Company();
        company4.setName("FedEx");
        company4.setDescription("A delivery company");
        companyRepository.save(company4);


        // Assign Users to Company
        user1.setCompanies(new ArrayList<>(List.of(company)));
        user2.setCompanies(new ArrayList<>(List.of(company)));
        user3.setCompanies(new ArrayList<>(List.of(company)));
        user4.setCompanies(new ArrayList<>(List.of(company)));
        user5.setCompanies(new ArrayList<>(List.of(company2)));
        user6.setCompanies(new ArrayList<>(List.of(company2)));
        user7.setCompanies(new ArrayList<>(List.of(company4, company2, company, company3)));
        user8.setCompanies(new ArrayList<>(List.of(company4)));
        user9.setCompanies(new ArrayList<>(List.of(company, company2, company3, company4)));
        user10.setCompanies(new ArrayList<>(List.of(company, company2, company3, company4)));
        user11.setCompanies(new ArrayList<>(List.of(company, company2, company3, company4)));
        user12.setCompanies(new ArrayList<>(List.of(company, company2, company3, company4)));
        userRepository.saveAll(List.of(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11, user12));

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

        Team team3 = new Team();
        team3.setName("Hooli Team");
        team3.setDescription("Handles all development");
        team3.setCompany(company.getId());
        team3.setUsers(new ArrayList<>(List.of(user9, user10, user11, user12)));

        teamRepository.saveAll(List.of(team1, team2, team3));

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

        Project project3 = new Project();
        project3.setName("Project GammaRay");
        project3.setDescription("A dangerous project");
        project3.setActive(false);
        project3.setTeam(team1.getId());

        Project project4 = new Project();
        project4.setName("Project Deepseek");
        project4.setDescription("A deep project");
        project4.setActive(true);
        project4.setTeam(team2.getId());

        Project project5 = new Project();
        project5.setName("Project FastTrack");
        project5.setDescription("A fast project");
        project5.setActive(true);
        project5.setTeam(team1.getId());

        Project project6 = new Project();
        project6.setName("Project MiddleOut");
        project6.setDescription("A middle out project");
        project6.setActive(true);
        project6.setTeam(team1.getId());


        projectRepository.saveAll(List.of(project1, project2, project3, project4, project5));

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

        Announcement announcement3 = new Announcement();
        announcement3.setDate(new java.sql.Timestamp(System.currentTimeMillis()));
        announcement3.setTitle("Completed FastTrack");
        announcement3.setMessage("We have completed the FastTrack project!");
        announcement3.setCompany(company);
        announcement3.setAuthor(user7);

        Announcement announcement4 = new Announcement();
        announcement4.setDate(new java.sql.Timestamp(System.currentTimeMillis()));
        announcement4.setTitle("New Hire");
        announcement4.setMessage("We have hired a new employee!");
        announcement4.setCompany(company);
        announcement4.setAuthor(user8);

        Announcement announcement5 = new Announcement();
        announcement5.setDate(new java.sql.Timestamp(System.currentTimeMillis()));
        announcement5.setTitle("Exposed to GammaRays");
        announcement5.setMessage("We have been exposed to GammaRays!");
        announcement5.setCompany(company2);

        Announcement announcement6 = new Announcement();
        announcement6.setDate(new java.sql.Timestamp(System.currentTimeMillis()));
        announcement6.setTitle("Richard Hendricks");
        announcement6.setMessage("Richard Hendricks middle out compression algorithm is a game changer!");
        announcement6.setCompany(company2);
        announcement6.setAuthor(user5);

        Announcement announcement7 = new Announcement();
        announcement7.setDate(new java.sql.Timestamp(System.currentTimeMillis()));
        announcement7.setTitle("Meseeks helper");
        announcement7.setMessage("Mr. Meseeks is here to help!");
        announcement7.setCompany(company2);
        announcement7.setAuthor(user6);


        Announcement announcement8 = new Announcement();
        announcement8.setDate(new java.sql.Timestamp(System.currentTimeMillis()));
        announcement8.setTitle("FedEx Delivery");
        announcement8.setMessage("FedEx has delivered the package!");
        announcement8.setCompany(company4);
        announcement8.setAuthor(user7);


        Announcement announcement9 = new Announcement();
        announcement9.setDate(new java.sql.Timestamp(System.currentTimeMillis()));
        announcement9.setTitle("Red Stapler");
        announcement9.setMessage("Who took my red stapler?");
        announcement9.setCompany(company4);
        announcement9.setAuthor(user8);

        Announcement announcement10 = new Announcement();
        announcement10.setDate(new java.sql.Timestamp(System.currentTimeMillis()));
        announcement10.setTitle("Hackerman");
        announcement10.setMessage("Hackerman has hacked into the system!");
        announcement10.setCompany(company4);
        announcement10.setAuthor(user6);

        announcementRepository.saveAll(List.of(announcement1, announcement2, announcement3, announcement4, announcement5, announcement6, announcement7, announcement8, announcement9, announcement10));
    }
}


//package com.cooksys.project_manager;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import com.cooksys.project_manager.entities.Announcement;
//import com.cooksys.project_manager.entities.Company;
//import com.cooksys.project_manager.entities.Credentials;
//import com.cooksys.project_manager.entities.Profile;
//import com.cooksys.project_manager.entities.Project;
//import com.cooksys.project_manager.entities.Team;
//import com.cooksys.project_manager.entities.User;
//import com.cooksys.project_manager.repositories.AnnouncementRepository;
//import com.cooksys.project_manager.repositories.CompanyRepository;
//import com.cooksys.project_manager.repositories.ProjectRepository;
//import com.cooksys.project_manager.repositories.TeamRepository;
//import com.cooksys.project_manager.repositories.UserRepository;
//
//import lombok.RequiredArgsConstructor;
//
//@Component
//@RequiredArgsConstructor
//public class Seeder implements CommandLineRunner {
//
//    private final UserRepository userRepository;
//    private final CompanyRepository companyRepository;
//    private final TeamRepository teamRepository;
//    private final ProjectRepository projectRepository;
//    private final AnnouncementRepository announcementRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Create Credentials
//        Credentials cred1 = new Credentials();
//        cred1.setUsername("john_doe");
//        cred1.setPassword("password");
//
//        Credentials cred2 = new Credentials();
//        cred2.setUsername("jane_smith");
//        cred2.setPassword("password");
//
//        Credentials cred3 = new Credentials();
//        cred3.setUsername("alice_wonder");
//        cred3.setPassword("securepass");
//
//        Credentials cred4 = new Credentials();
//        cred4.setUsername("bob_builder");
//        cred4.setPassword("strongpass");
//
//        // Create Profiles
//        Profile profile1 = new Profile();
//        profile1.setFirstName("John");
//        profile1.setLastName("Doe");
//        profile1.setEmail("john@example.com");
//        profile1.setPhone("1234567890");
//
//        Profile profile2 = new Profile();
//        profile2.setFirstName("Jane");
//        profile2.setLastName("Smith");
//        profile2.setEmail("jane@example.com");
//        profile2.setPhone("0987654321");
//
//        Profile profile3 = new Profile();
//        profile3.setFirstName("Alice");
//        profile3.setLastName("Wonder");
//        profile3.setEmail("alice@example.com");
//        profile3.setPhone("1112223333");
//
//        Profile profile4 = new Profile();
//        profile4.setFirstName("Bob");
//        profile4.setLastName("Builder");
//        profile4.setEmail("bob@example.com");
//        profile4.setPhone("4445556666");
//
//        // Create Users
//        User user1 = new User();
//        user1.setCredentials(cred1);
//        user1.setProfile(profile1);
//        user1.setActive(true);
//        user1.setAdmin(false);
//        user1.setStatus("active");
//
//        User user2 = new User();
//        user2.setCredentials(cred2);
//        user2.setProfile(profile2);
//        user2.setActive(true);
//        user2.setAdmin(true);
//        user2.setStatus("active");
//
//        User user3 = new User();
//        user3.setCredentials(cred3);
//        user3.setProfile(profile3);
//        user3.setActive(true);
//        user3.setAdmin(false);
//        user3.setStatus("active");
//
//        User user4 = new User();
//        user4.setCredentials(cred4);
//        user4.setProfile(profile4);
//        user4.setActive(true);
//        user4.setAdmin(false);
//        user4.setStatus("active");
//
//        userRepository.saveAll(List.of(user1, user2, user3, user4));
//
//        // Create Company
//        Company company = new Company();
//        company.setName("TechCorp");
//        company.setDescription("A leading tech company");
//        companyRepository.save(company);
//
//        // Assign Users to Company
//        user1.setCompanies(new ArrayList<>(List.of(company)));
//        user2.setCompanies(new ArrayList<>(List.of(company)));
//        user3.setCompanies(new ArrayList<>(List.of(company)));
//        user4.setCompanies(new ArrayList<>(List.of(company)));
//        userRepository.saveAll(List.of(user1, user2, user3, user4));
//
//        // Create Teams
//        Team team1 = new Team();
//        team1.setName("Development Team");
//        team1.setDescription("Handles all development");
//        team1.setCompany(company.getId());
//        team1.setUsers(new ArrayList<>(List.of(user1, user2)));
//
//        Team team2 = new Team();
//        team2.setName("QA Team");
//        team2.setDescription("Ensures quality");
//        team2.setCompany(company.getId());
//        team2.setUsers(new ArrayList<>(List.of(user3, user4)));
//
//        teamRepository.saveAll(List.of(team1, team2));
//
//        // Create Projects
//        Project project1 = new Project();
//        project1.setName("Project Alpha");
//        project1.setDescription("An innovative project");
//        project1.setActive(true);
//        project1.setTeam(team1.getId());
//
//        Project project2 = new Project();
//        project2.setName("Project Beta");
//        project2.setDescription("A high-priority project");
//        project2.setActive(true);
//        project2.setTeam(team2.getId());
//
//        projectRepository.saveAll(List.of(project1, project2));
//
//        // Create Announcements
//        Announcement announcement1 = new Announcement();
//        announcement1.setDate(new java.sql.Timestamp(System.currentTimeMillis()));
//        announcement1.setTitle("Launch Event");
//        announcement1.setMessage("We are launching soon!");
//        announcement1.setCompany(company);
//        announcement1.setAuthor(user1);
//
//        Announcement announcement2 = new Announcement();
//        announcement2.setDate(new java.sql.Timestamp(System.currentTimeMillis()));
//        announcement2.setTitle("New Project");
//        announcement2.setMessage("We have started working on a new project!");
//        announcement2.setCompany(company);
//        announcement2.setAuthor(user2);
//
//        announcementRepository.saveAll(List.of(announcement1, announcement2));
//    }
//}