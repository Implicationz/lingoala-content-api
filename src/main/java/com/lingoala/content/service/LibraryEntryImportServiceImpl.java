package com.lingoala.content.service;

import com.lingoala.content.domain.LibraryContent;
import com.lingoala.content.domain.LibraryContentPart;
import com.lingoala.content.domain.LibraryEntryImport;
import com.lingoala.content.dto.LibraryEntryImportDto;
import com.lingoala.content.mapper.LibraryEntryImportMapper;
import com.lingoala.content.repository.LibraryContentRepository;
import com.lingoala.content.repository.LibraryEntryRepository;
import com.lingoala.content.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class LibraryEntryImportServiceImpl implements LibraryEntryImportService {

    private final LibraryEntryRepository libraryEntryRepository;
    private final LibraryRepository libraryRepository;
    private final LibraryContentRepository libraryContentRepository;
    private final LibraryEntryImportMapper libraryEntryImportMapper;

    protected void updatePartsWithSavedChildren(LibraryContent libraryContent) {
        var parts = libraryContent.getParts();
        var childContents = parts.stream()
                .map(LibraryContentPart::getChild)
                .toList();
        var savedChildContents = libraryContentRepository.saveAll(childContents);
        for (var i = 0; i < savedChildContents.size(); i++) {
            var part = parts.get(i);
            part.setParent(libraryContent);
            part.setChild(savedChildContents.get(i));
        }
        libraryContentRepository.save(libraryContent);
    }

    @Override
    public LibraryEntryImportDto create(LibraryEntryImportDto libraryEntryImportDto) {
        var libraryEntryImport = libraryEntryImportMapper.toEntity(libraryEntryImportDto);
        var libraryEntry = libraryEntryImport.getLibraryEntry();
        var libraryContent = libraryEntry.getContent();
        var library = this.libraryRepository.getReferenceById(libraryEntry.getLibrary().getId());

        updatePartsWithSavedChildren(libraryContent);
        var savedLibraryContent =  libraryContentRepository.save(libraryContent);
        libraryEntry.setContent(savedLibraryContent);
        libraryEntry.setLibrary(library);

        var savedLibraryEntry = libraryEntryRepository.save(libraryEntry);
        log.info("LibraryEntryImport created with id: {}", savedLibraryEntry.getId());
        var savedLibraryEntryImport = LibraryEntryImport.builder()
                .libraryEntry(libraryEntry)
                .build();
        return libraryEntryImportMapper.toDto(savedLibraryEntryImport);
    }
}