package com.lingoala.content.mapper;


import com.lingoala.content.domain.LibraryContent;
import com.lingoala.content.domain.LibraryContentPart;
import com.lingoala.content.domain.LibraryEntry;
import com.lingoala.content.dto.LibraryContentDto;
import com.lingoala.content.dto.LibraryContentPartDto;
import com.lingoala.content.dto.LibraryEntryDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface LibraryEntryMapper {

    @Mapping(target = "library", ignore = true)
    LibraryEntryDto toDto(LibraryEntry libraryEntry);
    @Mapping(target = "library", ignore = true)
    LibraryEntry toEntity(LibraryEntryDto libraryEntryDto);

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


    @Mapping(target = "content", ignore = true)
    void updateEntityFromDto(LibraryEntryDto libraryEntryDto, @MappingTarget LibraryEntry libraryEntry);

}
