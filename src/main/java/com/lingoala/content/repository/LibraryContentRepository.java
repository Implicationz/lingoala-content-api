package com.lingoala.content.repository;

import com.lingoala.content.domain.LibraryContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LibraryContentRepository extends JpaRepository<LibraryContent, Long>, JpaSpecificationExecutor<LibraryContent> {
}
