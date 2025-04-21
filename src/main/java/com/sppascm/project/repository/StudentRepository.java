package com.sppascm.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sppascm.project.model.Student;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByKuId(String kuId);
}
