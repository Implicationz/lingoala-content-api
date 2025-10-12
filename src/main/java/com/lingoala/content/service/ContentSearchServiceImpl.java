package com.lingoala.content.service;

import com.lingoala.content.domain.ContentSearch;
import com.lingoala.content.domain.LibraryContent;
import com.lingoala.content.dto.ContentSearchDto;
import com.lingoala.content.mapper.ContentSearchMapper;
import com.lingoala.content.repository.LibraryContentRepository;
import com.lingoala.content.repository.LibraryContentSpecifications;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ContentSearchServiceImpl implements ContentSearchService {

    private final LibraryContentRepository libraryContentRepository;
    private final ContentSearchMapper contentSearchMapper;

    @Override
    public ContentSearchDto create(ContentSearchDto contentSearchDto) {
        var contentSearch = contentSearchMapper.toEntity(contentSearchDto);
        var found = search(contentSearch);
        var savedContentSearch = ContentSearch.builder()
                .subject(contentSearch.getSubject())
                .topic(contentSearch.getTopic())
                .entries(found)
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

        return libraryContentRepository.findAll(spec);
    }


}