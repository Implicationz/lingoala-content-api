package com.lingoala.content.mapper;

import com.lingoala.content.domain.Summary;
import com.lingoala.content.domain.SummaryTranslation;
import com.lingoala.content.dto.SummaryDto;
import com.lingoala.content.dto.SummaryTranslationDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface SummaryMapper {
    SummaryDto toDto(Summary summary);
    Summary toEntity(SummaryDto summaryDto);

    @Mapping(target = "summary", ignore = true)
    SummaryTranslationDto toDto(SummaryTranslation summaryTranslation);
    @Mapping(target = "summary", ignore = true)
    SummaryTranslation toEntity(SummaryTranslationDto summaryTranslationDto);

    @Mapping(target = "translations", ignore = true)
    void updateEntityFromDto(SummaryDto summaryDto, @MappingTarget Summary summary);

    @Mapping(target = "summary", ignore = true)
    void updateEntityFromDto(SummaryTranslationDto summaryTranslationDto, @MappingTarget SummaryTranslation summaryTranslation);
}
