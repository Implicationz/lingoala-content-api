package com.lingoala.content.service;

import com.lingoala.content.dto.LibraryEntryDto;

import java.util.List;

public interface LibraryEntryService {
    LibraryEntryDto create(LibraryEntryDto libraryEntry);
    LibraryEntryDto readById(Long id);
    List<LibraryEntryDto> readAll();
    LibraryEntryDto update(Long id, LibraryEntryDto libraryEntry);
    void delete(Long id);
}
