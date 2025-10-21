package com.lingoala.content.service;

import com.lingoala.content.dto.LibraryContentPartDto;

import java.util.List;

public interface LibraryContentPartService {
    LibraryContentPartDto create(LibraryContentPartDto libraryContentPart);
    LibraryContentPartDto readById(Long id);
    List<LibraryContentPartDto> readAll();
    LibraryContentPartDto update(Long id, LibraryContentPartDto libraryContentPart);
    void delete(Long id);
}
