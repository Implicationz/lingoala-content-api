package com.lingoala.content.service;

import com.lingoala.content.client.GamificationClient;
import com.lingoala.content.domain.LanguageCode;
import com.lingoala.content.domain.LibraryEntry;
import com.lingoala.content.domain.LibrarySearch;
import com.lingoala.content.domain.LibrarySearchHit;
import com.lingoala.content.dto.LibrarySearchDto;
import com.lingoala.content.mapper.LibrarySearchMapper;
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
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class LibrarySearchServiceImpl implements LibrarySearchService {

    private final LibraryRepository libraryRepository;
    private final LibraryEntryRepository libraryEntryRepository;
    private final LibrarySearchMapper librarySearchMapper;
    private final GamificationClient gamificationClient;

    protected List<LibrarySearchHit> toHits(List<LibraryEntry> found, List<GoalDto> goals) {
        var goalByRef = goals.stream()
                .collect(Collectors.toMap(
                        goal -> Long.parseLong(goal.getDefinition().getReference()),
                        Function.identity()
                ));

        var hits = found.stream()
                .map(entry -> {
                    var goal = goalByRef.getOrDefault(entry.getId(), null);
                    return LibrarySearchHit.builder()
                            .entry(entry)
                            .goal(goal)
                            .build();
                })
                .toList();
        return hits;
    }

    @Override
    public LibrarySearchDto create(LibrarySearchDto librarySearchDto) {
        var librarySearch = librarySearchMapper.toEntity(librarySearchDto);
        var found = search(librarySearch);
        var references = found.stream().map(e -> e.getId().toString()).toList();
        var language = LanguageCode.valueOf("zh");
        var goals = gamificationClient.getLibraryContentGoals(language, references);
        var hits = toHits(found, goals);
        var savedLibrarySearch = LibrarySearch.builder()
                .subject(librarySearch.getSubject())
                .topic(librarySearch.getTopic())
                .hits(hits)
                .build();
        log.info("LibrarySearch created with.");
        return librarySearchMapper.toDto(savedLibrarySearch);
    }

    protected List<LibraryEntry> search(LibrarySearch search) {
        Specification<LibraryEntry> spec = Specification.where(null);

        if (search.getSubject() != null) {
            spec = spec.and(LibraryEntrySpecifications.hasSubject(search.getSubject()));
        }
        if (search.getTopic() != null) {
            spec = spec.and(LibraryEntrySpecifications.hasTopic(search.getTopic()));
        }
        if (search.getLibrary() != null) {
            var libraryReference = libraryRepository.getReferenceById(search.getLibrary().getId());
            spec = spec.and(LibraryEntrySpecifications.hasLibrary(libraryReference));
        }

        var entries = libraryEntryRepository.findAll(spec);
        return entries;
    }

}