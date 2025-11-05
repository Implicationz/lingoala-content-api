package com.lingoala.content.service;

import com.lingoala.content.dto.SubjectDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SubjectService {
    SubjectDto create(SubjectDto subject);
    SubjectDto readById(Long id);
    List<SubjectDto> readAll();

    List<SubjectDto> readAll(String name);

    SubjectDto update(Long id, SubjectDto subject);
    void delete(Long id);
}
