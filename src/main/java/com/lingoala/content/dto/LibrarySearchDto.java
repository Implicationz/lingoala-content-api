package com.lingoala.content.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibrarySearchDto {
    private LibraryDto library;
    private SubjectDto subject;
    private TopicDto topic;
    private List<LibraryEntryDto> entries;
}
