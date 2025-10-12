package com.lingoala.content.service;


import com.lingoala.content.domain.LibraryContentImport;
import com.lingoala.content.dto.LibraryContentImportDto;
import com.lingoala.content.mapper.LibraryContentImportMapper;
import com.lingoala.content.repository.LibraryContentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class LibraryContentImportServiceImpl implements LibraryContentImportService {

    private final LibraryContentRepository libraryContentRepository;
    private final LibraryContentImportMapper libraryContentImportMapper;

    @Override
    public LibraryContentImportDto create(LibraryContentImportDto libraryContentImportDto) {
        var libraryContentImport = libraryContentImportMapper.toEntity(libraryContentImportDto);
        var libraryContent = libraryContentImport.getLibraryContent();
        var savedUnit = libraryContentRepository.save(libraryContent);
        log.info("LibraryContentImport created with id: {}", savedUnit.getId());
        var savedLibraryContentImport = LibraryContentImport.builder()
                .libraryContent(libraryContent)
                .build();
        return libraryContentImportMapper.toDto(savedLibraryContentImport);
    }
}