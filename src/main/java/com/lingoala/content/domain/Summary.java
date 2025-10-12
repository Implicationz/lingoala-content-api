package com.lingoala.content.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Summary extends BaseEntity {

    private String title;

    @Column(unique = true)
    private String reference;

    private LanguageCode language;

    @Column(columnDefinition = "TEXT")
    private String text;

    @Column(columnDefinition = "TEXT")
    private String transliteration;

    @OneToMany(mappedBy = "summary", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SummaryTranslation> translations;

}