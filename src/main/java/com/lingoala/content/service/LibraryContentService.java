package com.lingoala.content.service;

import com.lingoala.content.dto.LibraryContentDto;

import java.util.List;

public interface LibraryContentService {
    LibraryContentDto create(LibraryContentDto libraryContent);
    LibraryContentDto readById(Long id);
    List<LibraryContentDto> readAll();
    LibraryContentDto update(Long id, LibraryContentDto libraryContent);
    void delete(Long id);
}
