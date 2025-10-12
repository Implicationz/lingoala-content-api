package com.lingoala.content.dto;

import com.lingoala.content.domain.MaterialType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibraryMaterialDto {

    private Long id;
    private MaterialType type = MaterialType.TEXT;
    
    private String quiz;
    
    private String summary;

    private int questionCount = 0;
    private int wordCount = 0;
    
    private String artifact;

    private String goal;
}