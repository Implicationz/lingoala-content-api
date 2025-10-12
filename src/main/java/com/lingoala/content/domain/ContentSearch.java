package com.lingoala.content.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContentSearch {
    private LanguageCode language;
    private Subject subject;
    private Topic topic;
    private List<LibraryContent> entries;
}
