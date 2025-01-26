package com.project.diplomation.data.repositories;

import com.project.diplomation.data.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
