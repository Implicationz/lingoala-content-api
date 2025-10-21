package com.lingoala.content.service;

import com.lingoala.content.client.GamificationClient;
import com.lingoala.content.domain.*;
import com.lingoala.content.dto.LibraryCarouselDto;
import com.lingoala.content.mapper.LibraryCarouselMapper;
import com.lingoala.content.repository.LibraryEntryRepository;
import com.lingoala.content.repository.LibraryEntrySpecifications;
import com.lingoala.content.repository.LibraryRepository;
import com.lingoala.gamification.dto.GoalDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class LibraryCarouselServiceImpl implements LibraryCarouselService {

    private final LibraryRepository libraryRepository;
    private final LibraryEntryRepository libraryEntryRepository;
    private final LibraryCarouselMapper libraryCarouselMapper;
    private final GamificationClient gamificationClient;

    protected List<LibraryCarouselSlide> toSlides(List<LibraryEntry> found, List<GoalDto> goals) {
        var goalByRef = goals.stream()
                .collect(Collectors.toMap(
                        goal -> Long.parseLong(goal.getDefinition().getReference()),
                        Function.identity()
                ));

        var slides = found.stream()
                .map(entry -> {
                    var goal = goalByRef.getOrDefault(entry.getId(), null);
                    return LibraryCarouselSlide.builder()
                            .entry(entry)
                            .goal(goal)
                            .build();
                })
                .toList();
        return slides;
    }

    @Override
    public LibraryCarouselDto create(LibraryCarouselDto libraryCarouselDto) {
        var libraryCarousel = libraryCarouselMapper.toEntity(libraryCarouselDto);
        var library = libraryRepository.getReferenceById(libraryCarousel.getLibrary().getId());
        var found = libraryEntryRepository
                .findAllByLibraryOrderByCreatedAtDesc(library)
                .stream()
                .toList();

        var references = found.stream().map(e -> e.getContent().getId().toString()).toList();
        var goals = gamificationClient.getLibraryContentGoals(library.getLanguage(), references);
        var slides = toSlides(found, goals);
        
        var savedLibraryCarousel = LibraryCarousel.builder()
                .subject(libraryCarousel.getSubject())
                .topic(libraryCarousel.getTopic())
                .slides(slides)
                .build();
        log.info("LibraryCarousel created with.");
        return libraryCarouselMapper.toDto(savedLibraryCarousel);
    }
}