package com.lingoala.content.controller;

import com.lingoala.content.dto.ContentCarouselDto;
import com.lingoala.content.service.ContentCarouselService;
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
@RequestMapping("/content-carousel")
@RequiredArgsConstructor
@Tag(name = "ContentCarousel API")
public class ContentCarouselController {

    private final ContentCarouselService contentCarouselService;

    @PostMapping
    public ResponseEntity<ContentCarouselDto> search(@RequestBody @Valid ContentCarouselDto contentCarousel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contentCarouselService.create(contentCarousel));
    }

}