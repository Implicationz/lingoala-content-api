package com.lingoala.content.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class LibraryContentImportDto {
    protected LibraryContentDto libraryContent;
}