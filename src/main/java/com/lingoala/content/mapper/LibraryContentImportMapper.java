package com.lingoala.content.mapper;

import com.lingoala.content.domain.LibraryContentImport;
import com.lingoala.content.domain.LibraryContentPart;
import com.lingoala.content.dto.LibraryContentImportDto;
import com.lingoala.content.dto.LibraryContentPartDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface LibraryContentImportMapper {
    LibraryContentImportDto toDto(LibraryContentImport libraryContentImport);
    LibraryContentImport toEntity(LibraryContentImportDto libraryContentImportDto);

    @Mapping(target = "parent", ignore = true)
    LibraryContentPartDto toDto(LibraryContentPart libraryContentPart);
    @Mapping(target = "parent", ignore = true)
    LibraryContentPart toEntity(LibraryContentPartDto libraryContentPartDto);

}
