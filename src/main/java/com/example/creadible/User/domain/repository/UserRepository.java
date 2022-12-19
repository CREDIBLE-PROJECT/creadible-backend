package com.example.creadible.User.domain.repository;

import com.example.creadible.User.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByLoginId(String loginId);
}
