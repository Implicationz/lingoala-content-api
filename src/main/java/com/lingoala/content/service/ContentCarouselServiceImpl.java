package com.lingoala.content.service;

import com.lingoala.content.client.GamificationClient;
import com.lingoala.content.domain.ContentCarousel;
import com.lingoala.content.domain.ContentCarouselSlide;
import com.lingoala.content.domain.LibraryContent;
import com.lingoala.content.dto.ContentCarouselDto;
import com.lingoala.content.mapper.ContentCarouselMapper;
import com.lingoala.content.repository.LibraryContentRepository;
import com.lingoala.gamification.dto.GoalDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
public class ContentCarouselServiceImpl implements ContentCarouselService {

    private final LibraryContentRepository libraryContentRepository;
    private final ContentCarouselMapper contentCarouselMapper;
    private final GamificationClient gamificationClient;

    protected List<Long> extractReferences(List<GoalDto> goals) {
        return goals.stream()
                .map(goal -> goal.getDefinition().getReference())
                .map(Long::parseLong)
                .toList();
    }

    protected List<ContentCarouselSlide> toSlides(List<GoalDto> goals, List<LibraryContent> found) {
        var contentById = found.stream()
                .collect(Collectors.toMap(LibraryContent::getId, Function.identity()));

        var slides = goals.stream()
                .map(goal -> {
                    var ref = Long.parseLong(goal.getDefinition().getReference());
                    var content = contentById.get(ref);
                    if (content != null) {
                        return ContentCarouselSlide.builder()
                                .libraryContent(content)
                                .goal(goal)
                                .build();
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .toList();
        return slides;
    }

    @Override
    public ContentCarouselDto create(ContentCarouselDto contentCarouselDto) {
        var contentCarousel = contentCarouselMapper.toEntity(contentCarouselDto);
        var language = contentCarousel.getLanguage();
        var goals = gamificationClient.getIncompleteLibraryContentGoals(language);
        var references = extractReferences(goals);
        var found = libraryContentRepository.findAllById(references);
        var slides = toSlides(goals, found);

        var savedContentCarousel = ContentCarousel.builder()
                .subject(contentCarousel.getSubject())
                .topic(contentCarousel.getTopic())
                .slides(slides)
                .build();
        log.info("ContentCarousel created with.");
        return contentCarouselMapper.toDto(savedContentCarousel);
    }
}