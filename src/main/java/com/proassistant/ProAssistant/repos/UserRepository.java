package com.proassistant.ProAssistant.repos;

import com.proassistant.ProAssistant.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}
