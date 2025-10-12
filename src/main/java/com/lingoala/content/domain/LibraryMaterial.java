package com.lingoala.content.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibraryMaterial extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private MaterialType type = MaterialType.TEXT;
    
    private String quiz;
    
    private String summary;

    private int questionCount = 0;
    private int wordCount = 0;
    
    private String artifact;

    private String goal;
}