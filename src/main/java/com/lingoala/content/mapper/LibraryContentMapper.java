package com.lingoala.content.mapper;


import com.lingoala.content.domain.LibraryContent;
import com.lingoala.content.domain.LibraryContentPart;
import com.lingoala.content.dto.LibraryContentDto;
import com.lingoala.content.dto.LibraryContentPartDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface LibraryContentMapper {

    @Mapping(target = "parts.parent", ignore = true)
    @Mapping(target = "partOf.child", ignore = true)
    LibraryContentDto toDto(LibraryContent libraryContent);
    @Mapping(target = "parts.parent", ignore = true)
    @Mapping(target = "partOf.child", ignore = true)
    LibraryContent toEntity(LibraryContentDto libraryContentDto);

    @Mapping(target = "parent.partOf", ignore = true)
    @Mapping(target = "parent.parts", ignore = true)
    @Mapping(target = "child.partOf", ignore = true)
    @Mapping(target = "child.parts", ignore = true)
    LibraryContentPartDto toDto(LibraryContentPart libraryContentPart);
    @Mapping(target = "parent.partOf", ignore = true)
    @Mapping(target = "parent.parts", ignore = true)
    @Mapping(target = "child.partOf", ignore = true)
    @Mapping(target = "child.parts", ignore = true)
    LibraryContentPart toEntity(LibraryContentPartDto libraryContentPartDto);

    @Mapping(target = "parts", ignore = true)
    @Mapping(target = "partOf", ignore = true)
    @Mapping(target = "material.id", ignore = true)
    void updateEntityFromDto(LibraryContentDto libraryContentDto, @MappingTarget LibraryContent libraryContent);

    List<LibraryContentDto> toDto(List<LibraryContent> libraryContents);
    List<LibraryContent> toEntity(List<LibraryContentDto> libraryContentDtos);
}
