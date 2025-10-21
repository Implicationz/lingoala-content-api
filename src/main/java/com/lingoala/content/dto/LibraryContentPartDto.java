package com.lingoala.content.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibraryContentPartDto {

    private Long id;
    private LibraryContentDto parent;

    private int position;

    private LibraryContentDto child;

}