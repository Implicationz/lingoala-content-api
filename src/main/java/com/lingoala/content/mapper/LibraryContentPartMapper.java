package com.lingoala.content.mapper;


import com.lingoala.content.domain.LibraryContent;
import com.lingoala.content.domain.LibraryContentPart;
import com.lingoala.content.dto.LibraryContentDto;
import com.lingoala.content.dto.LibraryContentPartDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface LibraryContentPartMapper {

    @Mapping(target = "parent.parts", ignore = true)
    LibraryContentPartDto toDto(LibraryContentPart libraryContentPart);
    @Mapping(target = "parent.parts", ignore = true)
    LibraryContentPart toEntity(LibraryContentPartDto libraryContentPartDto);

    @Mapping(target = "partOf", ignore = true)
    @Mapping(target = "parts.parent", ignore = true)
    LibraryContentDto toDto(LibraryContent libraryContent);
    @Mapping(target = "partOf", ignore = true)
    @Mapping(target = "parts.parent", ignore = true)
    LibraryContent toEntity(LibraryContentDto libraryContentDto);

    @Mapping(target = "parent", ignore = true)
    @Mapping(target = "child", ignore = true)
    void updateEntityFromDto(LibraryContentPartDto libraryContentPartDto, @MappingTarget LibraryContentPart libraryContentPart);

}
