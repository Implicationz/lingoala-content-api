package com.lingoala.content.repository;

import com.lingoala.content.domain.LibraryEntry;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface LibraryEntryRepository extends JpaRepository<LibraryEntry, Long>, JpaSpecificationExecutor<LibraryEntry> {

    @Override
    @EntityGraph(attributePaths = {"content", "content.parts"})
    Optional<LibraryEntry> findById(Long id);

    @EntityGraph(attributePaths = {"content"})
    List<LibraryEntry> findAll(Specification<LibraryEntry> spec);
}
