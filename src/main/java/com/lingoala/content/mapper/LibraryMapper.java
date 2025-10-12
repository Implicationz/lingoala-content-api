package com.lingoala.content.mapper;


import com.lingoala.content.domain.Library;
import com.lingoala.content.domain.LibraryContent;
import com.lingoala.content.domain.LibraryEntry;
import com.lingoala.content.dto.LibraryContentDto;
import com.lingoala.content.dto.LibraryDto;
import com.lingoala.content.dto.LibraryEntryDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface LibraryMapper {
    LibraryDto toDto(Library library);
    Library toEntity(LibraryDto libraryDto);

    @Mapping(target = "library", ignore = true)
    LibraryEntryDto toDto(LibraryEntry libraryEntry);
    @Mapping(target = "library", ignore = true)
    LibraryEntry toEntity(LibraryEntryDto libraryEntryDto);

    @Mapping(target = "parts", ignore = true)
    LibraryContentDto toDto(LibraryContent libraryContent);
    @Mapping(target = "parts", ignore = true)
    LibraryContent toEntity(LibraryContentDto libraryContentDto);

    @Mapping(target = "entries", ignore = true)
    void updateEntityFromDto(LibraryDto libraryDto, @MappingTarget Library library);

    @Mapping(target = "library", ignore = true)
    void updateEntityFromDto(LibraryEntryDto libraryEntryDto, @MappingTarget LibraryEntry libraryEntry);

}
