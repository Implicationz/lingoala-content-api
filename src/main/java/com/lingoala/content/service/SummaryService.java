package com.lingoala.content.service;

import com.lingoala.content.dto.SummaryDto;

import java.util.List;

public interface SummaryService {
    SummaryDto create(SummaryDto summary);
    SummaryDto readById(Long id);
    List<SummaryDto> readAll();
    SummaryDto update(Long id, SummaryDto summary);
    void delete(Long id);
}
