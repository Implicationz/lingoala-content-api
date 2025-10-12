package com.lingoala.content.service;

import com.lingoala.content.dto.ContentTypeDto;

import java.util.List;

public interface ContentTypeService {
    ContentTypeDto create(ContentTypeDto contentType);
    ContentTypeDto readById(Long id);
    List<ContentTypeDto> readAll();
    ContentTypeDto update(Long id, ContentTypeDto contentType);
    void delete(Long id);
}
