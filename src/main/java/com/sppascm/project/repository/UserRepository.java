package com.sppascm.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sppascm.project.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
