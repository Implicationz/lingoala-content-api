package com.lingoala.content.controller;


import com.lingoala.content.dto.LibraryEntryImportDto;
import com.lingoala.content.service.LibraryEntryImportService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library-entry-import")
@RequiredArgsConstructor
@Tag(name = "LibraryEntryImport API")
public class LibraryEntryImportController {

    private final LibraryEntryImportService libraryEntryImportService;

    @PostMapping
    public ResponseEntity<LibraryEntryImportDto> create(@RequestBody @Valid LibraryEntryImportDto libraryEntryImport) {
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryEntryImportService.create(libraryEntryImport));
    }
}