package com.lingoala.content.controller;

import com.lingoala.content.dto.LibraryDto;
import com.lingoala.content.service.LibraryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
@RequiredArgsConstructor
@Tag(name = "Library API")
public class LibraryController {

    private final LibraryService libraryService;

    @PostMapping
    public ResponseEntity<LibraryDto> create(@RequestBody @Valid LibraryDto library) {
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryService.create(library));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryDto> readById(@PathVariable Long id) {
        return ResponseEntity.ok(libraryService.readById(id));
    }

    @GetMapping
    public ResponseEntity<List<LibraryDto>> readAll() {
        return ResponseEntity.ok(libraryService.readAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibraryDto> update(@PathVariable Long id, @RequestBody @Valid LibraryDto library) {
        return ResponseEntity.ok(libraryService.update(id, library));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        libraryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}