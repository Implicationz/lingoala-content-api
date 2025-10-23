package com.lingoala.content.controller;

import com.lingoala.content.dto.LibraryMaterialDto;
import com.lingoala.content.service.LibraryMaterialService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library-material")
@RequiredArgsConstructor
@Tag(name = "LibraryMaterial API")
public class LibraryMaterialController {

    private final LibraryMaterialService libraryMaterialService;

    @PostMapping
    public ResponseEntity<LibraryMaterialDto> create(@RequestBody @Valid LibraryMaterialDto libraryMaterial) {
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryMaterialService.create(libraryMaterial));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryMaterialDto> readById(@PathVariable Long id) {
        return ResponseEntity.ok(libraryMaterialService.readById(id));
    }

    @GetMapping
    public ResponseEntity<List<LibraryMaterialDto>> readAll() {
        return ResponseEntity.ok(libraryMaterialService.readAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibraryMaterialDto> update(@PathVariable Long id, @RequestBody @Valid LibraryMaterialDto libraryMaterial) {
        return ResponseEntity.ok(libraryMaterialService.update(id, libraryMaterial));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        libraryMaterialService.delete(id);
        return ResponseEntity.noContent().build();
    }
}