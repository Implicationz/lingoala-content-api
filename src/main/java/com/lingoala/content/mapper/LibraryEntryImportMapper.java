package com.lingoala.content.mapper;

import com.lingoala.content.domain.Library;
import com.lingoala.content.domain.LibraryContentPart;
import com.lingoala.content.domain.LibraryEntryImport;
import com.lingoala.content.dto.LibraryContentPartDto;
import com.lingoala.content.dto.LibraryDto;
import com.lingoala.content.dto.LibraryEntryImportDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface LibraryEntryImportMapper {
    LibraryEntryImportDto toDto(LibraryEntryImport libraryEntryImport);
    LibraryEntryImport toEntity(LibraryEntryImportDto libraryEntryImportDto);

    @Mapping(target = "entries", ignore = true)
    LibraryDto toDto(Library library);
    @Mapping(target = "entries", ignore = true)
    Library toEntity(LibraryDto libraryDto);

    @Mapping(target = "parent", ignore = true)
    LibraryContentPartDto toDto(LibraryContentPart libraryContentPart);
    @Mapping(target = "parent", ignore = true)
    LibraryContentPart toEntity(LibraryContentPartDto libraryContentPartDto);

}
