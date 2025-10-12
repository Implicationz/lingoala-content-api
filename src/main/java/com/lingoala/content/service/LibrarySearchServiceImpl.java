package com.lingoala.content.service;

import com.lingoala.content.domain.LibraryEntry;
import com.lingoala.content.domain.LibrarySearch;
import com.lingoala.content.dto.LibrarySearchDto;
import com.lingoala.content.mapper.LibrarySearchMapper;
import com.lingoala.content.repository.LibraryEntryRepository;
import com.lingoala.content.repository.LibraryEntrySpecifications;
import com.lingoala.content.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class LibrarySearchServiceImpl implements LibrarySearchService {

    private final LibraryRepository libraryRepository;
    private final LibraryEntryRepository libraryEntryRepository;
    private final LibrarySearchMapper librarySearchMapper;

    @Override
    public LibrarySearchDto create(LibrarySearchDto librarySearchDto) {
        var librarySearch = librarySearchMapper.toEntity(librarySearchDto);
        var found = search(librarySearch);
        var savedLibrarySearch = LibrarySearch.builder()
                .subject(librarySearch.getSubject())
                .topic(librarySearch.getTopic())
                .entries(found)
                .build();
        log.info("LibrarySearch created with.");
        return librarySearchMapper.toDto(savedLibrarySearch);
    }

    protected List<LibraryEntry> search(LibrarySearch search) {
        Specification<LibraryEntry> spec = Specification.where(null);

        if (search.getSubject() != null) {
            spec = spec.and(LibraryEntrySpecifications.hasSubject(search.getSubject()));
        }
        if (search.getTopic() != null) {
            spec = spec.and(LibraryEntrySpecifications.hasTopic(search.getTopic()));
        }
        if (search.getLibrary() != null) {
            var libraryReference = libraryRepository.getReferenceById(search.getLibrary().getId());
            spec = spec.and(LibraryEntrySpecifications.hasLibrary(libraryReference));
        }
        // Optional: Filter nach Type, falls gewünscht
        // if (search.getType() != null) {
        //     spec = spec.and(LibraryEntrySpecifications.hasType(search.getType()));
        // }

        var entries = libraryEntryRepository.findAll(spec);
        return entries;
    }

}