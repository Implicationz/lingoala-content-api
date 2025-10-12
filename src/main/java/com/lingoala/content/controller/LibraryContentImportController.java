package com.lingoala.content.controller;


import com.lingoala.content.dto.LibraryContentImportDto;
import com.lingoala.content.service.LibraryContentImportService;
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
@RequestMapping("/library-content-import")
@RequiredArgsConstructor
@Tag(name = "LibraryContentImport API")
public class LibraryContentImportController {

    private final LibraryContentImportService libraryContentImportService;

    @PostMapping
    public ResponseEntity<LibraryContentImportDto> create(@RequestBody @Valid LibraryContentImportDto libraryContentImport) {
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryContentImportService.create(libraryContentImport));
    }
}