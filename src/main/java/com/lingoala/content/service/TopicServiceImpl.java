package com.lingoala.content.service;

import com.lingoala.content.dto.TopicDto;
import com.lingoala.content.exception.ResourceNotFoundException;
import com.lingoala.content.mapper.TopicMapper;
import com.lingoala.content.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TopicServiceImpl implements TopicService {

    private final SubjectService subjectService;
    private final TopicRepository topicRepository;
    private final TopicMapper topicMapper;

    @Override
    public TopicDto create(TopicDto topicDto) {
        var topic = topicMapper.toEntity(topicDto);
        var savedTopic = topicRepository.save(topic);
        return topicMapper.toDto(savedTopic);
    }

    @Override
    @Transactional(readOnly = true)
    public TopicDto readById(Long id) {
        var topic = topicRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Topic not found"));
        return topicMapper.toDto(topic);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TopicDto> readAll() {
        return topicRepository.findAll().stream()
                .map(topicMapper::toDto)
                .toList();
    }

    @Override
    public TopicDto update(Long id, TopicDto topicDto) {
        var existingTopic = topicRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Topic not found"));

        var savedTopic = topicRepository.save(existingTopic);
        return topicMapper.toDto(savedTopic);
    }

    @Override
    public void delete(Long id) {
        topicRepository.deleteById(id);
    }
}