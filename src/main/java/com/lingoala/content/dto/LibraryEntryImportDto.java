package com.lingoala.content.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class LibraryEntryImportDto {
    protected LibraryEntryDto libraryEntry;
}