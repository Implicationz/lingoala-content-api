package com.lingoala.content.mapper;


import com.lingoala.content.domain.LibraryContent;
import com.lingoala.content.domain.LibraryEntry;
import com.lingoala.content.domain.LibrarySearch;
import com.lingoala.content.dto.LibraryContentDto;
import com.lingoala.content.dto.LibraryEntryDto;
import com.lingoala.content.dto.LibrarySearchDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface LibrarySearchMapper {
    
    LibrarySearchDto toDto(LibrarySearch librarySearch);
    LibrarySearch toEntity(LibrarySearchDto librarySearchDto);

    @Mapping(target = "library", ignore = true)
    LibraryEntryDto toDto(LibraryEntry libraryEntry);
    @Mapping(target = "library", ignore = true)
    LibraryEntry toEntity(LibraryEntryDto libraryEntryDto);

    @Mapping(target = "parts", ignore = true)
    LibraryContentDto toDto(LibraryContent libraryContent);
    @Mapping(target = "parts", ignore = true)
    LibraryContent toEntity(LibraryContentDto libraryContentDto);
}
