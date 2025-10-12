package com.lingoala.content.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Library extends BaseEntity {

    @Column(nullable = false)
    private LanguageCode language;
    private String title;

    @BatchSize(size = 30)
    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LibraryEntry> entries;
}