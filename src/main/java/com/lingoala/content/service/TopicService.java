package com.lingoala.content.service;

import com.lingoala.content.dto.TopicDto;

import java.util.List;

public interface TopicService {
    TopicDto create(TopicDto topic);
    TopicDto readById(Long id);
    List<TopicDto> readAll();
    TopicDto update(Long id, TopicDto topic);
    void delete(Long id);
}
