package com.lingoala.content.controller;

import com.lingoala.content.dto.ContentSearchDto;
import com.lingoala.content.service.ContentSearchService;
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
@RequestMapping("/content-search")
@RequiredArgsConstructor
@Tag(name = "ContentSearch API")
public class ContentSearchController {

    private final ContentSearchService contentSearchService;

    @PostMapping
    public ResponseEntity<ContentSearchDto> search(@RequestBody @Valid ContentSearchDto contentSearch) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contentSearchService.create(contentSearch));
    }

}