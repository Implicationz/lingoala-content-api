package com.lingoala.content.dto;

import com.lingoala.content.domain.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContentCarouselDto {
    private LanguageCode language;
    private SubjectDto subject;
    private TopicDto topic;
    private List<ContentCarouselSlideDto> slides;
    private ContentSearchSort sort;
}
