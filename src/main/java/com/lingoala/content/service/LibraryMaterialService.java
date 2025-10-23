package com.lingoala.content.service;

import com.lingoala.content.dto.LibraryMaterialDto;

import java.util.List;

public interface LibraryMaterialService {
    LibraryMaterialDto create(LibraryMaterialDto libraryMaterial);
    LibraryMaterialDto readById(Long id);
    List<LibraryMaterialDto> readAll();
    LibraryMaterialDto update(Long id, LibraryMaterialDto libraryMaterial);
    void delete(Long id);
}
