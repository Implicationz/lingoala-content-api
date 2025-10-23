package com.lingoala.content.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibraryCarouselDto {
    private LibraryDto library;
    private SubjectDto subject;
    private TopicDto topic;
    private List<LibraryCarouselSlideDto> slides;
}
