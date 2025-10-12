package com.lingoala.content.mapper;

import com.lingoala.content.domain.Subject;
import com.lingoala.content.dto.SubjectDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface SubjectMapper {
    SubjectDto toDto(Subject subject);
    Subject toEntity(SubjectDto subjectDto);

}
