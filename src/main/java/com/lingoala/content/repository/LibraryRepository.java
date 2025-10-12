package com.lingoala.content.repository;

import com.lingoala.content.domain.LanguageCode;
import com.lingoala.content.domain.Library;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibraryRepository extends JpaRepository<Library, Long> {
    Optional<Library> findByLanguage(LanguageCode language);
}
