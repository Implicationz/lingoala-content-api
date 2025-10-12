package com.lingoala.content.controller;

import com.lingoala.content.dto.LibrarySearchDto;
import com.lingoala.content.service.LibrarySearchService;
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
@RequestMapping("/library-search")
@RequiredArgsConstructor
@Tag(name = "LibrarySearch API")
public class LibrarySearchController {

    private final LibrarySearchService librarySearchService;

    @PostMapping
    public ResponseEntity<LibrarySearchDto> search(@RequestBody @Valid LibrarySearchDto librarySearch) {
        return ResponseEntity.status(HttpStatus.CREATED).body(librarySearchService.create(librarySearch));
    }

}