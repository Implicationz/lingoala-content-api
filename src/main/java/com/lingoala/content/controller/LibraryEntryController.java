package com.lingoala.content.controller;

import com.lingoala.content.dto.LibraryEntryDto;
import com.lingoala.content.service.LibraryEntryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library-entry")
@RequiredArgsConstructor
@Tag(name = "LibraryEntry API")
public class LibraryEntryController {

    private final LibraryEntryService libraryEntryService;

    @PostMapping
    public ResponseEntity<LibraryEntryDto> create(@RequestBody @Valid LibraryEntryDto libraryEntry) {
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryEntryService.create(libraryEntry));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryEntryDto> readById(@PathVariable Long id) {
        return ResponseEntity.ok(libraryEntryService.readById(id));
    }

    @GetMapping
    public ResponseEntity<List<LibraryEntryDto>> readAll() {
        return ResponseEntity.ok(libraryEntryService.readAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibraryEntryDto> update(@PathVariable Long id, @RequestBody @Valid LibraryEntryDto libraryEntry) {
        return ResponseEntity.ok(libraryEntryService.update(id, libraryEntry));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        libraryEntryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}