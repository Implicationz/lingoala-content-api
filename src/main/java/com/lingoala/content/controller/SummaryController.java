package com.lingoala.content.controller;


import com.lingoala.content.dto.SummaryDto;
import com.lingoala.content.service.SummaryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/summary")
@RequiredArgsConstructor
@Tag(name = "Summary API")
public class SummaryController {

    private final SummaryService summaryService;

    @PostMapping
    public ResponseEntity<SummaryDto> create(@RequestBody @Valid SummaryDto summary) {
        return ResponseEntity.status(HttpStatus.CREATED).body(summaryService.create(summary));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SummaryDto> readById(@PathVariable Long id) {
        return ResponseEntity.ok(summaryService.readById(id));
    }

    @GetMapping
    public ResponseEntity<List<SummaryDto>> readAll() {
        return ResponseEntity.ok(summaryService.readAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SummaryDto> update(@PathVariable Long id, @RequestBody @Valid SummaryDto summary) {
        return ResponseEntity.ok(summaryService.update(id, summary));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        summaryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}