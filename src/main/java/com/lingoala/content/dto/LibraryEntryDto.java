package com.lingoala.content.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibraryEntryDto  {

    private Long id;
    private LibraryDto library;
    private LibraryContentDto content;

}