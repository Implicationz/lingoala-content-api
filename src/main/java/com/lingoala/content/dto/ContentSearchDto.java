package com.lingoala.content.dto;

import com.lingoala.content.domain.ContentSearchSort;
import com.lingoala.content.domain.LanguageCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContentSearchDto {
    private LanguageCode language;
    private SubjectDto subject;
    private TopicDto topic;
    private List<ContentSearchHitDto> hits;
    private ContentSearchSort sort;
}
