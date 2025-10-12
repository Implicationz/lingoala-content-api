package com.lingoala.content.mapper;


import com.lingoala.content.domain.Library;
import com.lingoala.content.domain.LibraryContentPart;
import com.lingoala.content.domain.LibraryEntry;
import com.lingoala.content.dto.LibraryContentPartDto;
import com.lingoala.content.dto.LibraryDto;
import com.lingoala.content.dto.LibraryEntryDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface LibraryEntryMapper {
    LibraryEntryDto toDto(LibraryEntry libraryEntry);
    LibraryEntry toEntity(LibraryEntryDto libraryEntryDto);

    @Mapping(target = "entries", ignore = true)
    LibraryDto toDto(Library library);
    @Mapping(target = "entries", ignore = true)
    Library toEntity(LibraryDto libraryDto);

    @Mapping(target = "parent", ignore = true)
    @Mapping(target = "child.parts", ignore = true)
    LibraryContentPartDto toDto(LibraryContentPart libraryContentPart);
    @Mapping(target = "parent", ignore = true)
    @Mapping(target = "child.parts", ignore = true)
    LibraryContentPart toEntity(LibraryContentPartDto libraryContentPartDto);

    void updateEntityFromDto(LibraryEntryDto libraryEntryDto, @MappingTarget LibraryEntry libraryEntry);

}
