package com.lingoala.content.dto;

import com.lingoala.content.domain.Library;
import com.lingoala.content.domain.LibraryEntry;
import com.lingoala.content.domain.Subject;
import com.lingoala.content.domain.Topic;
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
