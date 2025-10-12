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
public interface LibraryContentMapper {
    LibraryContentDto toDto(LibraryContent libraryContent);
    LibraryContent toEntity(LibraryContentDto libraryContentDto);

    @Mapping(target = "parent", ignore = true)
    LibraryContentPartDto toDto(LibraryContentPart libraryContentPart);
    @Mapping(target = "parent", ignore = true)
    LibraryContentPart toEntity(LibraryContentPartDto libraryContentPartDto);

    void updateEntityFromDto(LibraryContentDto libraryContentDto, @MappingTarget LibraryContent libraryContent);

}
