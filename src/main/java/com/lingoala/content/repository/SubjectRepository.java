package com.lingoala.content.repository;

import com.lingoala.content.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findByNameStartingWithIgnoreCase(String name);
}