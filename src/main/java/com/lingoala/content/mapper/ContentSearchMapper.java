package com.lingoala.content.mapper;


import com.lingoala.content.domain.ContentSearch;
import com.lingoala.content.domain.LibraryContent;
import com.lingoala.content.dto.ContentSearchDto;
import com.lingoala.content.dto.LibraryContentDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ContentSearchMapper {
    
    ContentSearchDto toDto(ContentSearch contentSearch);
    ContentSearch toEntity(ContentSearchDto contentSearchDto);

    @Mapping(target = "parts", ignore = true)
    LibraryContentDto toDto(LibraryContent libraryContent);
    @Mapping(target = "parts", ignore = true)
    LibraryContent toEntity(LibraryContentDto libraryContentDto);
}
