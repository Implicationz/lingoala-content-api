package com.lingoala.content.service;


import com.lingoala.content.dto.LibraryMaterialDto;
import com.lingoala.content.exception.ResourceNotFoundException;
import com.lingoala.content.mapper.LibraryMaterialMapper;
import com.lingoala.content.repository.LibraryMaterialRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class LibraryMaterialServiceImpl implements LibraryMaterialService {

    private final LibraryMaterialRepository libraryMaterialRepository;
    private final LibraryMaterialMapper libraryMaterialMapper;

    @Override
    public LibraryMaterialDto create(LibraryMaterialDto libraryMaterialDto) {
        var libraryMaterial = libraryMaterialMapper.toEntity(libraryMaterialDto);
        var savedLibraryMaterial = libraryMaterialRepository.save(libraryMaterial);
        log.info("LibraryMaterial created with id: {}", savedLibraryMaterial.getId());
        return libraryMaterialMapper.toDto(savedLibraryMaterial);
    }

    @Override
    @Transactional(readOnly = true)
    public LibraryMaterialDto readById(Long id) {
        var libraryMaterial = libraryMaterialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LibraryMaterial not found"));
        log.info("LibraryMaterial found with id: {}", id);
        return libraryMaterialMapper.toDto(libraryMaterial);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LibraryMaterialDto> readAll() {
        log.info("Reading all libraryMaterials");
        return libraryMaterialRepository.findAll().stream().map(libraryMaterialMapper::toDto).toList();
    }

    @Override
    public LibraryMaterialDto update(Long id, LibraryMaterialDto libraryMaterialDto) {
        var existingLibraryMaterial = libraryMaterialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LibraryMaterial not found"));
        libraryMaterialMapper.updateEntityFromDto(libraryMaterialDto, existingLibraryMaterial);
        log.info("LibraryMaterial updated with id: {}", id);
        return libraryMaterialMapper.toDto(existingLibraryMaterial);
    }

    @Override
    public void delete(Long id) {
        libraryMaterialRepository.deleteById(id);
        log.info("LibraryMaterial deleted with id: {}", id);
    }
}