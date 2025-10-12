package com.lingoala.content.repository;

import com.lingoala.content.domain.Summary;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SummaryRepository extends JpaRepository<Summary, Long> {
    @EntityGraph(attributePaths = {"translations"})
    @Override
    Optional<Summary> findById(Long id);
}
