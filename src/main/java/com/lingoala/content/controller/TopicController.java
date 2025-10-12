package com.lingoala.content.controller;
import com.lingoala.content.dto.TopicDto;
import com.lingoala.content.service.TopicService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topic")
@RequiredArgsConstructor
@Tag(name = "Topic API")
public class TopicController {

    private final TopicService topicService;

    @PostMapping
    public ResponseEntity<TopicDto> create(@RequestBody @Valid TopicDto topic) {
        return ResponseEntity.status(HttpStatus.CREATED).body(topicService.create(topic));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDto> readById(@PathVariable Long id) {
        return ResponseEntity.ok(topicService.readById(id));
    }

    @GetMapping
    public ResponseEntity<List<TopicDto>> readAll() {
        return ResponseEntity.ok(topicService.readAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicDto> update(@PathVariable Long id, @RequestBody @Valid TopicDto topic) {
        return ResponseEntity.ok(topicService.update(id, topic));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        topicService.delete(id);
        return ResponseEntity.noContent().build();
    }
}