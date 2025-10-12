package com.lingoala.content.dto;

import com.lingoala.content.domain.LanguageCode;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibraryDto {

    private Long id;
    private LanguageCode language;
    private List<LibraryEntryDto> entries;
}