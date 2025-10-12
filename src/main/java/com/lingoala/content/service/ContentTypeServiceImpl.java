package com.lingoala.content.service;

import com.lingoala.content.dto.ContentTypeDto;
import com.lingoala.content.exception.ResourceNotFoundException;
import com.lingoala.content.mapper.ContentTypeMapper;
import com.lingoala.content.repository.ContentTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ContentTypeServiceImpl implements ContentTypeService {

    private final ContentTypeRepository contentTypeRepository;
    private final ContentTypeMapper contentTypeMapper;

    @Override
    public ContentTypeDto create(ContentTypeDto contentTypeDto) {
        var contentType = contentTypeMapper.toEntity(contentTypeDto);
        var savedContentType = contentTypeRepository.save(contentType);
        log.info("ContentType created with id: {}", savedContentType.getId());
        return contentTypeMapper.toDto(savedContentType);
    }

    @Override
    @Transactional(readOnly = true)
    public ContentTypeDto readById(Long id) {
        var contentType = contentTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ContentType not found"));
        log.info("ContentType found with id: {}", id);
        return contentTypeMapper.toDto(contentType);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContentTypeDto> readAll() {
        log.info("Reading all contentTypes");
        return contentTypeRepository.findAll().stream()
                .map(contentTypeMapper::toDto)
                .toList();
    }

    @Override
    public ContentTypeDto update(Long id, ContentTypeDto contentTypeDto) {
        var existingContentType = contentTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ContentType not found"));
        var savedContentType = contentTypeRepository.save(existingContentType);
        log.info("ContentType updated with id: {}", id);
        return contentTypeMapper.toDto(savedContentType);
    }

    @Override
    public void delete(Long id) {
        contentTypeRepository.deleteById(id);
        log.info("ContentType deleted with id: {}", id);
    }
}