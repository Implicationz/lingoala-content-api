package com.lingoala.content.dto;

import com.lingoala.content.domain.ContentDifficulty;
import com.lingoala.content.domain.LanguageCode;
import com.lingoala.content.domain.Visibility;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibraryContentDto {

    private Long id;
    private String title;
    private String titleTranslation;
    private String titleTranscription;

    private SubjectDto subject;
    private TopicDto topic;
    private LanguageCode language;
    private ContentTypeDto type;
    private ContentDifficulty difficulty = ContentDifficulty.A1;
    private Visibility visibility = Visibility.PRIVATE;
    private UUID ownerId;
    private int estimatedDuration;
    private String image;

    private LibraryMaterialDto material;
    private List<LibraryContentPartDto> partOf;
    private List<LibraryContentPartDto> parts;
}