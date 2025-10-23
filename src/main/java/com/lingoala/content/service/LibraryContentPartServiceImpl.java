package com.lingoala.content.service;


import com.lingoala.content.dto.LibraryContentPartDto;
import com.lingoala.content.exception.ResourceNotFoundException;
import com.lingoala.content.mapper.LibraryContentPartMapper;
import com.lingoala.content.repository.LibraryContentPartRepository;
import com.lingoala.content.repository.LibraryContentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class LibraryContentPartServiceImpl implements LibraryContentPartService {

    private final LibraryContentPartRepository libraryContentPartRepository;
    private final LibraryContentRepository libraryContentRepository;
    private final LibraryContentPartMapper libraryContentPartMapper;

    @Override
    public LibraryContentPartDto create(LibraryContentPartDto libraryContentPartDto) {
        var libraryContentPart = libraryContentPartMapper.toEntity(libraryContentPartDto);
        var savedLibraryContentPart = libraryContentPartRepository.save(libraryContentPart);
        log.info("LibraryContentPart created with id: {}", savedLibraryContentPart.getId());
        return libraryContentPartMapper.toDto(savedLibraryContentPart);
    }

    @Override
    @Transactional(readOnly = true)
    public LibraryContentPartDto readById(Long id) {
        var libraryContentPart = libraryContentPartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LibraryContentPart not found"));
        log.info("LibraryContentPart found with id: {}", id);
        return libraryContentPartMapper.toDto(libraryContentPart);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LibraryContentPartDto> readAll() {
        log.info("Reading all libraryContentParts");
        return libraryContentPartRepository.findAll().stream()
                .map(libraryContentPartMapper::toDto)
                .toList();
    }

    @Override
    public LibraryContentPartDto update(Long id, LibraryContentPartDto libraryContentPartDto) {
        var existingLibraryContentPart = libraryContentPartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LibraryContentPart not found"));
        libraryContentPartMapper.updateEntityFromDto(libraryContentPartDto, existingLibraryContentPart);
        var parent = libraryContentRepository.getReferenceById(libraryContentPartDto.getParent().getId());
        existingLibraryContentPart.setParent(parent);
        var child = libraryContentRepository.getReferenceById(libraryContentPartDto.getChild().getId());
        existingLibraryContentPart.setChild(child);
        log.info("LibraryContentPart updated with id: {}", id);
        return libraryContentPartMapper.toDto(existingLibraryContentPart);
    }

    @Override
    public void delete(Long id) {
        libraryContentPartRepository.deleteById(id);
        log.info("LibraryContentPart deleted with id: {}", id);
    }
}