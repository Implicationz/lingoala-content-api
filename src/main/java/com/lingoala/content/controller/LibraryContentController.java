package com.lingoala.content.controller;

import com.lingoala.content.dto.LibraryContentDto;
import com.lingoala.content.service.LibraryContentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library-content")
@RequiredArgsConstructor
@Tag(name = "LibraryContent API")
public class LibraryContentController {

    private final LibraryContentService libraryContentService;

    @PostMapping
    public ResponseEntity<LibraryContentDto> create(@RequestBody @Valid LibraryContentDto libraryContent) {
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryContentService.create(libraryContent));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryContentDto> readById(@PathVariable Long id) {
        return ResponseEntity.ok(libraryContentService.readById(id));
    }

    @GetMapping
    public ResponseEntity<List<LibraryContentDto>> readAll() {
        return ResponseEntity.ok(libraryContentService.readAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibraryContentDto> update(@PathVariable Long id, @RequestBody @Valid LibraryContentDto libraryContent) {
        return ResponseEntity.ok(libraryContentService.update(id, libraryContent));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        libraryContentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}