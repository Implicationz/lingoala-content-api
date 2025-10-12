package com.lingoala.content.controller;
import com.lingoala.content.dto.ContentTypeDto;
import com.lingoala.content.service.ContentTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content-type")
@RequiredArgsConstructor
@Tag(name = "ContentType API")
public class ContentTypeController {

    private final ContentTypeService contentTypeService;

    @PostMapping
    public ResponseEntity<ContentTypeDto> create(@RequestBody @Valid ContentTypeDto contentType) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contentTypeService.create(contentType));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContentTypeDto> readById(@PathVariable Long id) {
        return ResponseEntity.ok(contentTypeService.readById(id));
    }

    @GetMapping
    public ResponseEntity<List<ContentTypeDto>> readAll() {
        return ResponseEntity.ok(contentTypeService.readAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContentTypeDto> update(@PathVariable Long id, @RequestBody @Valid ContentTypeDto contentType) {
        return ResponseEntity.ok(contentTypeService.update(id, contentType));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contentTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}