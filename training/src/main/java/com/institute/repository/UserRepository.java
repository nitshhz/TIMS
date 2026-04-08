package com.institute.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.institute.model.AppUser;
import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Integer> {
    Optional<AppUser> findByUsername(String username);
}
