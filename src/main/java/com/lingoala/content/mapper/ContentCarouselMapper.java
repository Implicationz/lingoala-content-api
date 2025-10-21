package com.lingoala.content.mapper;


import com.lingoala.content.domain.ContentCarousel;
import com.lingoala.content.domain.LibraryContent;
import com.lingoala.content.dto.ContentCarouselDto;
import com.lingoala.content.dto.LibraryContentDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ContentCarouselMapper {
    
    ContentCarouselDto toDto(ContentCarousel contentCarousel);
    ContentCarousel toEntity(ContentCarouselDto contentCarouselDto);

    @Mapping(target = "parts", ignore = true)
    @Mapping(target = "partOf", ignore = true)
    LibraryContentDto toDto(LibraryContent libraryContent);
    @Mapping(target = "parts", ignore = true)
    @Mapping(target = "partOf", ignore = true)
    LibraryContent toEntity(LibraryContentDto libraryContentDto);
}
