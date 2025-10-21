package com.lingoala.content.service;


import com.lingoala.content.dto.LibraryEntryDto;
import com.lingoala.content.exception.ResourceNotFoundException;
import com.lingoala.content.mapper.LibraryEntryMapper;
import com.lingoala.content.repository.LibraryContentRepository;
import com.lingoala.content.repository.LibraryEntryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class LibraryEntryServiceImpl implements LibraryEntryService {

    private final LibraryEntryRepository libraryEntryRepository;
    private final LibraryContentRepository libraryContentRepository;
    private final LibraryEntryMapper libraryEntryMapper;

    @Override
    public LibraryEntryDto create(LibraryEntryDto libraryEntryDto) {
        var libraryEntry = libraryEntryMapper.toEntity(libraryEntryDto);
        var savedLibraryEntry = libraryEntryRepository.save(libraryEntry);
        log.info("LibraryEntry created with id: {}", savedLibraryEntry.getId());
        return libraryEntryMapper.toDto(savedLibraryEntry);
    }

    @Override
    @Transactional(readOnly = true)
    public LibraryEntryDto readById(Long id) {
        var libraryEntry = libraryEntryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LibraryEntry not found"));
        log.info("LibraryEntry found with id: {}", id);
        return libraryEntryMapper.toDto(libraryEntry);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LibraryEntryDto> readAll() {
        log.info("Reading all libraryEntrys");
        return libraryEntryRepository.findAll().stream()
                .map(libraryEntryMapper::toDto)
                .toList();
    }

    @Override
    public LibraryEntryDto update(Long id, LibraryEntryDto libraryEntryDto) {
        var existingLibraryEntry = libraryEntryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LibraryEntry not found"));
        libraryEntryMapper.updateEntityFromDto(libraryEntryDto, existingLibraryEntry);
        var content = libraryContentRepository.getReferenceById(libraryEntryDto.getContent().getId());
        existingLibraryEntry.setContent(content);
        log.info("LibraryEntry updated with id: {}", id);
        return libraryEntryMapper.toDto(existingLibraryEntry);
    }

    @Override
    public void delete(Long id) {
        libraryEntryRepository.deleteById(id);
        log.info("LibraryEntry deleted with id: {}", id);
    }
}