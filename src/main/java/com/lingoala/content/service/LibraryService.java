package com.lingoala.content.service;

import com.lingoala.content.dto.LibraryDto;
import com.lingoala.content.dto.LibraryRegistrationDto;

import java.util.List;

public interface LibraryService {
    LibraryDto create(LibraryDto library);
    LibraryDto readById(Long id);
    List<LibraryDto> readAll();
    LibraryDto update(Long id, LibraryDto library);
    void delete(Long id);

    LibraryRegistrationDto register(LibraryRegistrationDto libraryRegistration);
}
