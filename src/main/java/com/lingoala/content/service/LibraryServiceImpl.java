package com.lingoala.content.service;


import com.lingoala.content.domain.LibraryEntry;
import com.lingoala.content.dto.LibraryDto;
import com.lingoala.content.dto.LibraryEntryDto;
import com.lingoala.content.dto.LibraryRegistrationDto;
import com.lingoala.content.exception.ResourceNotFoundException;
import com.lingoala.content.mapper.LibraryMapper;
import com.lingoala.content.repository.LibraryRepository;
import com.lingoala.content.utility.EntitySyncUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class LibraryServiceImpl implements LibraryService {

    private final LibraryRepository libraryRepository;
    private final LibraryMapper libraryMapper;

    @Override
    public LibraryDto create(LibraryDto libraryDto) {
        var library = libraryMapper.toEntity(libraryDto);
        var savedLibrary = libraryRepository.save(library);
        log.info("Library created with id: {}", savedLibrary.getId());
        return libraryMapper.toDto(savedLibrary);
    }

    @Override
    @Transactional(readOnly = true)
    public LibraryDto readById(Long id) {
        var library = libraryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Library not found"));
        log.info("Library found with id: {}", id);
        return libraryMapper.toDto(library);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LibraryDto> readAll() {
        log.info("Reading all librarys");
        return libraryRepository.findAll().stream()
                .map(libraryMapper::toDto)
                .toList();
    }

    @Override
    public LibraryDto update(Long id, LibraryDto libraryDto) {
        var existingLibrary = libraryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Library not found"));
        libraryMapper.updateEntityFromDto(libraryDto, existingLibrary);
        EntitySyncUtils.syncChildEntities(existingLibrary.getEntries(), libraryDto.getEntries(),
                LibraryEntry::getId,
                LibraryEntryDto::getId,
                libraryMapper::toEntity,
                entry -> entry.setLibrary(existingLibrary),
                libraryMapper::updateEntityFromDto
                );
        libraryRepository.flush();
        log.info("Library updated with id: {}", id);
        return libraryMapper.toDto(existingLibrary);
    }

    @Override
    public void delete(Long id) {
        libraryRepository.deleteById(id);
        log.info("Library deleted with id: {}", id);
    }

    @Override
    public LibraryRegistrationDto register(LibraryRegistrationDto libraryRegistration) {
        var library = this.libraryMapper.toEntity(libraryRegistration.getLibrary());
        var registeredLibrary = libraryRepository
                .findByLanguage(library.getLanguage())
                .orElseGet(() -> {
                    var newLibrary = libraryRepository.save(library);
                    log.info("Library created with id: {}", newLibrary.getId());
                    return newLibrary;
                });
        return LibraryRegistrationDto
                .builder()
                .library(this.libraryMapper.toDto(registeredLibrary))
                .build();
    }
}