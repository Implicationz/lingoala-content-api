package com.lingoala.content.repository;

import com.lingoala.content.domain.LibraryContent;
import com.lingoala.content.domain.LibraryContentPart;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface LibraryContentRepository extends JpaRepository<LibraryContent, Long>, JpaSpecificationExecutor<LibraryContent> {

    @Override
    @EntityGraph(attributePaths = {"material", "partOf", "partOf.parent"})
    Optional<LibraryContent> findById(Long id);
}
