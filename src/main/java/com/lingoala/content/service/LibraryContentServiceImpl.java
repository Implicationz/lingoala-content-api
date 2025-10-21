package com.lingoala.content.service;


import com.lingoala.content.domain.LibraryContentPart;
import com.lingoala.content.dto.LibraryContentDto;
import com.lingoala.content.dto.LibraryContentPartDto;
import com.lingoala.content.exception.ResourceNotFoundException;
import com.lingoala.content.mapper.LibraryContentMapper;
import com.lingoala.content.repository.LibraryContentRepository;
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
public class LibraryContentServiceImpl implements LibraryContentService {

    private final LibraryContentRepository libraryContentRepository;
    private final LibraryContentMapper libraryContentMapper;

    @Override
    public LibraryContentDto create(LibraryContentDto libraryContentDto) {
        var libraryContent = libraryContentMapper.toEntity(libraryContentDto);
        var savedLibraryContent = libraryContentRepository.save(libraryContent);
        log.info("LibraryContent created with id: {}", savedLibraryContent.getId());
        return libraryContentMapper.toDto(savedLibraryContent);
    }

    @Override
    @Transactional(readOnly = true)
    public LibraryContentDto readById(Long id) {
        var libraryContent = libraryContentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LibraryContent not found"));
        log.info("LibraryContent found with id: {}", id);
        return libraryContentMapper.toDto(libraryContent);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LibraryContentDto> readAll() {
        log.info("Reading all libraryContents");
        return libraryContentMapper.toDto(libraryContentRepository.findAll().stream().toList());
    }

    @Override
    public LibraryContentDto update(Long id, LibraryContentDto libraryContentDto) {
        var existingLibraryContent = libraryContentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LibraryContent not found"));
        libraryContentMapper.updateEntityFromDto(libraryContentDto, existingLibraryContent);
        EntitySyncUtils.syncChildEntities(existingLibraryContent.getParts(), libraryContentDto.getParts(),
                LibraryContentPart::getId,
                LibraryContentPartDto::getId,
                libraryContentMapper::toEntity,
                (part) -> {
                    part.setParent(existingLibraryContent);
                },
                (partDto, part) -> {
                    part.setParent(existingLibraryContent);
                    var child = libraryContentRepository.getReferenceById(partDto.getChild().getId());
                    part.setChild(child);
                    part.setPosition(partDto.getPosition());
                }
        );
        log.info("LibraryContent updated with id: {}", id);
        return libraryContentMapper.toDto(existingLibraryContent);
    }

    @Override
    public void delete(Long id) {
        libraryContentRepository.deleteById(id);
        log.info("LibraryContent deleted with id: {}", id);
    }
}