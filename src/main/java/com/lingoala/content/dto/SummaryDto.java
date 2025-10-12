package com.lingoala.content.dto;

import com.lingoala.content.domain.LanguageCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SummaryDto {

    private Long id;
    private String title;
    private String reference;
    private LanguageCode language;
    private String text;
    private String transliteration;
    private List<SummaryTranslationDto> translations;

}