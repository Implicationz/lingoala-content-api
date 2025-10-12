package com.lingoala.content.mapper;

import com.lingoala.content.domain.Topic;
import com.lingoala.content.dto.TopicDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface TopicMapper {
    TopicDto toDto(Topic topic);
    Topic toEntity(TopicDto topicDto);

}
