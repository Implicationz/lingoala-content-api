package com.lingoala.content.service;

import com.lingoala.content.client.GamificationClient;
import com.lingoala.content.domain.ContentSearch;
import com.lingoala.content.domain.ContentSearchHit;
import com.lingoala.content.domain.ContentSearchSort;
import com.lingoala.content.domain.LibraryContent;
import com.lingoala.content.dto.ContentSearchDto;
import com.lingoala.content.mapper.ContentSearchMapper;
import com.lingoala.content.repository.LibraryContentRepository;
import com.lingoala.content.repository.LibraryContentSpecifications;
import com.lingoala.gamification.dto.GoalDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ContentSearchServiceImpl implements ContentSearchService {

    private final AccountService accountService;
    private final LibraryContentRepository libraryContentRepository;
    private final ContentSearchMapper contentSearchMapper;
    private final GamificationClient gamificationClient;

    protected List<ContentSearchHit> toHits(List<LibraryContent> found, List<GoalDto> goals) {
        var goalByRef = goals.stream()
                .collect(Collectors.toMap(
                        goal -> Long.parseLong(goal.getDefinition().getReference()),
                        Function.identity()
                ));

        var hits = found.stream()
                .map(content -> {
                    var goal = goalByRef.getOrDefault(content.getId(), null);
                    return ContentSearchHit.builder()
                            .content(content)
                            .goal(goal)
                            .build();
                })
                .toList();
        return hits;
    }
    @Override
    public ContentSearchDto create(ContentSearchDto contentSearchDto) {
        var contentSearch = contentSearchMapper.toEntity(contentSearchDto);
        var found = search(contentSearch);
        var references = found.stream().map(e -> e.getId().toString()).toList();
        var goals = gamificationClient.getLibraryContentGoals(contentSearch.getLanguage(), references);
        var hits = toHits(found, goals);
        var savedContentSearch = ContentSearch.builder()
                .subject(contentSearch.getSubject())
                .topic(contentSearch.getTopic())
                .hits(hits)
                .build();
        log.info("ContentSearch created with.");
        return contentSearchMapper.toDto(savedContentSearch);
    }

    protected List<LibraryContent> search(ContentSearch search) {
        Specification<LibraryContent> spec = Specification.where(null);

        if (search.getLanguage() != null) {
            spec = spec.and(LibraryContentSpecifications.hasLanguage(search.getLanguage()));
        }
        if (search.getSubject() != null) {
            spec = spec.and(LibraryContentSpecifications.hasSubject(search.getSubject()));
        }
        if (search.getTopic() != null) {
            spec = spec.and(LibraryContentSpecifications.hasTopic(search.getTopic()));
        }

        if (ContentSearchSort.RANDOM.equals(search.getSort())) {
            spec = spec.and(LibraryContentSpecifications.randomOrder());
        }

        var account = accountService.readCurrent();
        spec = spec.and(LibraryContentSpecifications.isVisible(account));

        return libraryContentRepository.findAll(spec);
    }


}