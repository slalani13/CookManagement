package com.cooksys.project_manager.repositories;

// <<<<<<< shariq_backend
// import com.cooksys.project_manager.dtos.CredentialsDto;
// import com.cooksys.project_manager.entities.Credentials;
// =======
import java.util.List;

import java.util.Optional;

// >>>>>>> dev
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.project_manager.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
// <<<<<<< shariq_backend

    Optional<User> findByCredentialsUsernameAndCredentialsPassword(String username, String password);

    Optional<User> findById(Long id);

//     User findByIdAndIsActiveTrue(Long id);
    Optional<User> findByCredentialsUsernameAndIsActiveTrue(String username);
    List<User> findAllByIdAndIsActiveTrue(Long id);
    Optional<User> findByIdAndIsActiveTrue(Long id);

}
