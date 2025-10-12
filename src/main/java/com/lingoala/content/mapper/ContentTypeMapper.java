package com.lingoala.content.mapper;

import com.lingoala.content.domain.ContentType;
import com.lingoala.content.dto.ContentTypeDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ContentTypeMapper {
    ContentTypeDto toDto(ContentType contentType);
    ContentType toEntity(ContentTypeDto contentTypeDto);

}
