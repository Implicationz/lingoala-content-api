package com.lingoala.content.controller;

import com.lingoala.content.dto.LibraryRegistrationDto;
import com.lingoala.content.service.LibraryService;
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
@RequestMapping("/library-registration")
@RequiredArgsConstructor
@Tag(name = "Library API")
public class LibraryRegistrationController {

    private final LibraryService libraryService;

    @PostMapping
    public ResponseEntity<LibraryRegistrationDto> create(@RequestBody @Valid LibraryRegistrationDto libraryRegistration) {
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryService.register(libraryRegistration));
    }
}