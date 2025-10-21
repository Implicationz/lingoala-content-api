package com.lingoala.content.controller;

import com.lingoala.content.dto.LibraryCarouselDto;
import com.lingoala.content.service.LibraryCarouselService;
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
@RequestMapping("/library-carousel")
@RequiredArgsConstructor
@Tag(name = "LibraryCarousel API")
public class LibraryCarouselController {

    private final LibraryCarouselService libraryCarouselService;

    @PostMapping
    public ResponseEntity<LibraryCarouselDto> search(@RequestBody @Valid LibraryCarouselDto libraryCarousel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryCarouselService.create(libraryCarousel));
    }

}