package com.lingoala.content.mapper;


import com.lingoala.content.domain.LibraryMaterial;
import com.lingoala.content.dto.LibraryMaterialDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface LibraryMaterialMapper {

    LibraryMaterialDto toDto(LibraryMaterial libraryMaterial);
    LibraryMaterial toEntity(LibraryMaterialDto libraryMaterialDto);
    void updateEntityFromDto(LibraryMaterialDto libraryMaterialDto, @MappingTarget LibraryMaterial libraryMaterial);
}
