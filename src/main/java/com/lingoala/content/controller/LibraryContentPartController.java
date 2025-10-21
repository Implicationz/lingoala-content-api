package com.lingoala.content.controller;

import com.lingoala.content.dto.LibraryContentPartDto;
import com.lingoala.content.service.LibraryContentPartService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library-content-part")
@RequiredArgsConstructor
@Tag(name = "LibraryContentPart API")
public class LibraryContentPartController {

    private final LibraryContentPartService libraryContentPartService;

    @PostMapping
    public ResponseEntity<LibraryContentPartDto> create(@RequestBody @Valid LibraryContentPartDto libraryContentPart) {
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryContentPartService.create(libraryContentPart));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryContentPartDto> readById(@PathVariable Long id) {
        return ResponseEntity.ok(libraryContentPartService.readById(id));
    }

    @GetMapping
    public ResponseEntity<List<LibraryContentPartDto>> readAll() {
        return ResponseEntity.ok(libraryContentPartService.readAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibraryContentPartDto> update(@PathVariable Long id, @RequestBody @Valid LibraryContentPartDto libraryContentPart) {
        return ResponseEntity.ok(libraryContentPartService.update(id, libraryContentPart));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        libraryContentPartService.delete(id);
        return ResponseEntity.noContent().build();
    }
}